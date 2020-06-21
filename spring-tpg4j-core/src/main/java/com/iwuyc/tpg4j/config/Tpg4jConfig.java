package com.iwuyc.tpg4j.config;

import org.springframework.core.Ordered;

public class Tpg4jConfig implements Ordered {
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}
