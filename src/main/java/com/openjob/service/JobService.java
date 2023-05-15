package com.openjob.service;

import com.openjob.model.dto.enums.EmailCase;
import com.openjob.model.dto.shared.JobDTO;
import com.openjob.model.entity.Candidate;
import com.openjob.model.entity.Company;
import com.openjob.model.entity.Job;
import com.openjob.model.mapper.JobMapper;
import com.openjob.repository.JobRepository;
import com.openjob.util.EmailUtils;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.naming.InsufficientResourcesException;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class JobService extends BaseService<Job, String> {
    private final JobRepository jobRepository;
    private final CompanyService companyService;
    private final MongoTemplate mongoTemplate;
    private final JobMapper jobMapper;
    private final PriceCalculationService priceCalculationService;
    private final EmailUtils emailUtils;

    @Override
    protected void init() {
        repository = this.jobRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = Job.class;
    }

    public Page<Job> getByCompanyId(String companyId) {
        Company company = companyService.getById(companyId);
        return new PageImpl<>(company.getJobs());
    }

    public boolean disable(String id) throws MessagingException, TemplateException, IOException {
        Job job = getById(id);
        job.setIsActive(false);
        saveUpdate(job, job.getId());
        // send notification mail
        for (Candidate candidate : job.getCandidates()){
            Map<String, Object> data = new HashMap<>();
            data.put("job", job);
            data.put("candidate", candidate);
            emailUtils.sendEmail(candidate.getAccount().getUsername(), "A job you applied has been closed", data, EmailCase.JOB_DEACTIVATED);
        }
        return true;
    }

    public boolean enable(String id) throws MessagingException, TemplateException, IOException {
        Job job = getById(id);
        job.setIsActive(true);
        saveUpdate(job, job.getId());
        // send notification mail
        for (Candidate candidate : job.getCandidates()){
            Map<String, Object> data = new HashMap<>();
            data.put("job", job);
            data.put("candidate", candidate);
            emailUtils.sendEmail(candidate.getAccount().getUsername(), "A closed job has been re-opened", data, EmailCase.JOB_REACTIVATED);
        }
        return true;
    }

    private int[] getTenRandomNumbers(int n) {
        int[] result = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            result[i] = rand.nextInt(n);
        }
        return result;
    }

    public List<JobDTO> get10FeaturedJobs(){
        List<JobDTO> toReturn = new ArrayList<>();
        // get premium company and its jobs
        List<Company> premiumCompanies = companyService.getAll("!deletedAt&isPremium=true").getContent();
        List<Job> featuredJobs = new ArrayList<>();
        premiumCompanies.forEach(company -> {
            company.getJobs().forEach(job -> {
                if (job.getIsActive() && Objects.isNull(job.getDeletedAt()))
                    featuredJobs.add(job);
            });
        });
        // randomly get 10 job
        int[] tenRandomNumbers = getTenRandomNumbers(featuredJobs.size());
        for (int randomNumber : tenRandomNumbers) {
            toReturn.add(jobMapper.toDTO(featuredJobs.get(randomNumber)));
        }

        return toReturn;
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void softDeleteExpiredJobs(){
        Long now = new Date().getTime();
        List<Job> expiredJobs = getAll("!deletedAt&expiredAt>"+now).getContent();
        for (Job expiredJob : expiredJobs){
            expiredJob.setDeletedAt(now);
            expiredJob.setModifiedAt(now);
        }
        saveAll(expiredJobs);
    }

    private void saveAll(List<Job> jobs){
        jobRepository.saveAll(jobs);
    }


    public Job createNewJob(JobDTO dto) throws InsufficientResourcesException {
        Job job = jobMapper.toEntity(dto);
        Company company = companyService.getById(dto.getCompanyId());

        double price = priceCalculationService.calculateJobPrice(company, job);
        if (price < company.getBalance()){
            throw new InsufficientResourcesException("User balance is not enough to complete action");
        }

        job.setCompany(company);
        job.setIsActive(true);

        Job savedJob = saveUpdate(job, job.getId());

        if (Objects.isNull(company.getJobs()))
            company.setJobs(new ArrayList<>());
        company.getJobs().add(savedJob);
        company.setAmountOfJobs(company.getAmountOfJobs() - 1); // reduce amount of available job posts
        company.setBalance(company.getBalance() - price); // reduce balance
        companyService.saveUpdate(company, company.getId());

        return savedJob;
    }

    // Company edit job
    public Job editJob(JobDTO dto) throws MessagingException, TemplateException, IOException {
        Job updatedJob = saveUpdate(jobMapper.toEntity(dto), dto.getId());
        // send notification mail
        for (Candidate candidate : updatedJob.getCandidates()){
            Map<String, Object> data = new HashMap<>();
            data.put("job", updatedJob);
            data.put("candidate", candidate);
            emailUtils.sendEmail(candidate.getAccount().getUsername(), "A job has updated", data, EmailCase.JOB_UPDATED);
        }
        return updatedJob;
    }
}
