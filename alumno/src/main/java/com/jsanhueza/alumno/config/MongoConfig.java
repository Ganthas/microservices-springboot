package com.jsanhueza.alumno.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages="com.jsanhueza.alumno.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "otecMicro";
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        return new MongoClient("localhost", 27017);
    }
}
