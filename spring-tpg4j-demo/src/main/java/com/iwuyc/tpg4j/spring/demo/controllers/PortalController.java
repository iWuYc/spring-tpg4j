package com.iwuyc.tpg4j.spring.demo.controllers;

import com.iwuyc.tpg4j.core.Tpg4jFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController()
@RequestMapping("/portal")
public class PortalController {

    private static final Logger log = LoggerFactory.getLogger(PortalController.class);

    final ExecutorService executorService = Tpg4jFactory.get(PortalController.class);
    final ScheduledExecutorService scheduleService = Tpg4jFactory.getScheduleService(PortalController.class);

    @GetMapping
    public String get() {
        final long startTime = System.currentTimeMillis();
        log.warn("提交。" + startTime);

        scheduleService.schedule(() -> log.warn("print:" + (System.currentTimeMillis() - startTime)), 10, TimeUnit.SECONDS);
        return "test";
    }
}
