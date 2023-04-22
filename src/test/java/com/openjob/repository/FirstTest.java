package com.openjob.repository;

import com.openjob.service.CompanyService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@DataMongoTest
//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FirstTest {
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private MongoTemplate mongoTemplate;
    @InjectMocks
    private CompanyService service;

    @Test
    public void testInsertUser() {

    }
}
