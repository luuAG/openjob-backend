package com.openjob.service;

import com.openjob.model.entity.Skill;
import com.openjob.repository.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkillService extends BaseService<Skill, String> {
    private final SkillRepository skillRepository;
    private final MongoTemplate mongoTemplate;


    @Override
    protected void init() {
        repository = this.skillRepository;
        baseMongoTemplate = this.mongoTemplate;
        clazz = Skill.class;
    }

}
