package com.iwuyc.tpg4j.spring.core.annotations;

import com.iwuyc.tpg4j.spring.core.config.Tpg4jConfigSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(Tpg4jConfigSelector.class)
public @interface EnableTpg4j {
    /**
     * 配置文件路径，yaml格式的配置文件
     *
     * @return 配置文件路径
     */
    String value() default "classpath:/tpg4j/tpg4j.yaml";

    Class<?>[] dependencies() default {};
}
