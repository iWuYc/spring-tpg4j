package com.iwuyc.tpg4j.spring.demo;

import org.springframework.stereotype.Service;

@Service
public class ServiceDependency {
    public void hello() {
        System.out.println("hello");
    }
}
