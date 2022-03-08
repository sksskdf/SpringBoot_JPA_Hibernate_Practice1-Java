package com.har.springbootjpa3.config;

import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Configuration
public class DBConfiguration {

    @PersistenceContext
    private EntityManager entityManager;

}
