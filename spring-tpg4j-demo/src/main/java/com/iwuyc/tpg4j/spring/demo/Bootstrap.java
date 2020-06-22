package com.iwuyc.tpg4j.spring.demo;

import com.iwuyc.tpg4j.spring.core.annotations.EnableTpg4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableTpg4j(dependencies = ServiceDependency.class)
@ComponentScan({"com.iwuyc"})
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class);

    }
}
