package com.biscoito.axon.config;

import com.mongodb.MongoClient;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.mongo.DefaultMongoTemplate;
import org.axonframework.mongo.eventsourcing.eventstore.MongoEventStorageEngine;
import org.axonframework.spring.eventhandling.scheduling.quartz.QuartzEventSchedulerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    @Autowired
    private MongoClient mongoClient;

    @Bean
    public EventStorageEngine eventStorageEngine() {
        return new MongoEventStorageEngine(new DefaultMongoTemplate(mongoClient));
    }

    @Bean
    public QuartzEventSchedulerFactoryBean simpleEventSchedulerFactoryBean() throws Exception {
        return new QuartzEventSchedulerFactoryBean();
    }
}
