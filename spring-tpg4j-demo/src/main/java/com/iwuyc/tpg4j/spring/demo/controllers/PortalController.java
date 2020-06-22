package com.iwuyc.tpg4j.spring.demo.controllers;

import com.iwuyc.tpg4j.Tpg4jFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController()
@RequestMapping("/portal")
public class PortalController {

    final ExecutorService executorService = Tpg4jFactory.get(PortalController.class);
    final ScheduledExecutorService scheduleService = Tpg4jFactory.getScheduleService(PortalController.class);

    @GetMapping
    public String get() {
        final long startTime = System.currentTimeMillis();
        System.out.println("提交。" + startTime);
        scheduleService.schedule(() -> System.out.println("print:" + (System.currentTimeMillis() - startTime)), 10, TimeUnit.SECONDS);
        return "test";
    }
}
