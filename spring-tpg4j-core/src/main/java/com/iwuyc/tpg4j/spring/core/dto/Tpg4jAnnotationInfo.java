package com.iwuyc.tpg4j.spring.core.dto;

import lombok.Data;
import lombok.ToString;

/**
 * 引入tpg4j框架的一些必要参数
 */
@Data
@ToString
public class Tpg4jAnnotationInfo {
    private String configPath;
    private Class<?>[] dependencies;
}
