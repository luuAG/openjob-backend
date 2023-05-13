package com.openjob.service;

import com.openjob.model.dto.enums.JobLevel;
import com.openjob.model.entity.Company;
import com.openjob.model.entity.Job;
import com.openjob.model.entity.OpenjobBusiness;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PriceCalculationService {
    private final OpenjobBusinessService openjobBusinessService;

    public double calculateJobPrice(Company company, Job job){
        // if company still has free job post
        if (company.getAmountOfJobs() > 0){
            return 0;
        }
        // calculate as openjob business
        double finalPrice;
        OpenjobBusiness businessParameters = openjobBusinessService.get();

        double weight;
        JobLevel jobLevel = JobLevel.fromValue(job.getJobLevel());
        switch (jobLevel){
            case INTERN -> weight = businessParameters.getInternWeight();
            case FRESHER -> weight = businessParameters.getFresherWeight();
            case JUNIOR -> weight = businessParameters.getJuniorWeight();
            case MIDDLE -> weight = businessParameters.getMiddleWeight();
            case SENIOR -> weight = businessParameters.getSeniorWeight();
            default -> weight = businessParameters.getHighPositionWeight();
        }

        finalPrice = businessParameters.getBaseJobPricePerDay()
                * weight
                * job.getRecruitingAmount()
                * job.getDurationInDays();

        return finalPrice;
    }
}
