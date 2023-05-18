package com.openjob.model.mapper;

import com.openjob.model.dto.shared.JobDTO;
import com.openjob.model.entity.Job;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-18T23:03:45+0700",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.6 (Oracle Corporation)"
)
@Component
public class JobMapperImpl implements JobMapper {

    @Autowired
    private JobSkillMapper jobSkillMapper;

    @Override
    public JobDTO toDTO(Job entity) {
        if ( entity == null ) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();

        jobDTO.setId( entity.getId() );
        jobDTO.setCreatedAt( entity.getCreatedAt() );
        jobDTO.setModifiedAt( entity.getModifiedAt() );
        jobDTO.setDeletedAt( entity.getDeletedAt() );
        jobDTO.setIsActive( entity.getIsActive() );
        jobDTO.setTitle( entity.getTitle() );
        jobDTO.setExpiredAt( entity.getExpiredAt() );
        jobDTO.setJobType( entity.getJobType() );
        jobDTO.setJobLevel( entity.getJobLevel() );
        jobDTO.setWorkplace( entity.getWorkplace() );
        List<String> list = entity.getAddresses();
        if ( list != null ) {
            jobDTO.setAddresses( new ArrayList<String>( list ) );
        }
        jobDTO.setDescription( entity.getDescription() );
        jobDTO.setRequirement( entity.getRequirement() );
        jobDTO.setBenefit( entity.getBenefit() );
        jobDTO.setSalaryInfo( entity.getSalaryInfo() );
        jobDTO.setRecruitingAmount( entity.getRecruitingAmount() );
        jobDTO.setDurationInDays( entity.getDurationInDays() );
        jobDTO.setJobSkills( jobSkillMapper.toDTO( entity.getJobSkills() ) );

        return jobDTO;
    }

    @Override
    public Job toEntity(JobDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Job job = new Job();

        job.setId( dto.getId() );
        job.setCreatedAt( dto.getCreatedAt() );
        job.setModifiedAt( dto.getModifiedAt() );
        job.setDeletedAt( dto.getDeletedAt() );
        job.setIsActive( dto.getIsActive() );
        job.setTitle( dto.getTitle() );
        job.setExpiredAt( dto.getExpiredAt() );
        job.setJobType( dto.getJobType() );
        job.setJobLevel( dto.getJobLevel() );
        job.setWorkplace( dto.getWorkplace() );
        List<String> list = dto.getAddresses();
        if ( list != null ) {
            job.setAddresses( new ArrayList<String>( list ) );
        }
        job.setDescription( dto.getDescription() );
        job.setRequirement( dto.getRequirement() );
        job.setBenefit( dto.getBenefit() );
        job.setSalaryInfo( dto.getSalaryInfo() );
        job.setRecruitingAmount( dto.getRecruitingAmount() );
        job.setDurationInDays( dto.getDurationInDays() );
        job.setJobSkills( jobSkillMapper.toEntity( dto.getJobSkills() ) );

        return job;
    }

    @Override
    public List<JobDTO> toDTO(List<Job> entities) {
        if ( entities == null ) {
            return null;
        }

        List<JobDTO> list = new ArrayList<JobDTO>( entities.size() );
        for ( Job job : entities ) {
            list.add( toDTO( job ) );
        }

        return list;
    }

    @Override
    public List<Job> toEntity(List<JobDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Job> list = new ArrayList<Job>( dtoList.size() );
        for ( JobDTO jobDTO : dtoList ) {
            list.add( toEntity( jobDTO ) );
        }

        return list;
    }
}
