package com.openjob.service;

import com.openjob.model.entity.Company;
import com.openjob.model.entity.Job;
import com.openjob.model.mapper.JobMapper;
import com.openjob.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobService extends BaseService<Job, String> {
    private final JobRepository jobRepository;
    private final CompanyService companyService;
    private final MongoTemplate mongoTemplate;
    private final JobMapper jobMapper;


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
}
