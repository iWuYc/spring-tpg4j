package com.iwuyc.tpg4j.spring.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ServiceDependency {
    private static final Logger log = LoggerFactory.getLogger(ServiceDependency.class);

    public ServiceDependency() {
        log.error("ServiceDependency init.");

    }

    public void hello() {
        log.error("hello");
    }
}
