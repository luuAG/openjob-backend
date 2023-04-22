package com.openjob;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.openjob.repository")
public class OpenJobWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenJobWebApplication.class, args);
    }
}
