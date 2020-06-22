package com.iwuyc.tpg4j.spring.core.config;

import com.iwuyc.tpg4j.spring.core.annotations.EnableTpg4j;
import com.iwuyc.tpg4j.spring.core.dto.Tpg4jAnnotationInfo;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.concurrent.CompletableFuture;

public class Tpg4jConfigSelector implements ImportSelector {
    public static final CompletableFuture<Tpg4jAnnotationInfo> TPG_4_J_ANNOTATION_INFO_COMPLETABLE_FUTURE = new CompletableFuture<>();

    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        try {
            final Class<?> clazz = Class.forName(importingClassMetadata.getClassName());
            final EnableTpg4j annotation = clazz.getAnnotation(EnableTpg4j.class);

            final Tpg4jAnnotationInfo tpg4jInfo = new Tpg4jAnnotationInfo();
            tpg4jInfo.setConfigPath(annotation.value());
            tpg4jInfo.setDependencies(annotation.dependencies());

            TPG_4_J_ANNOTATION_INFO_COMPLETABLE_FUTURE.complete(tpg4jInfo);
        } catch (ClassNotFoundException ignored) {

        }
        return new String[]{Tpg4jConfigPostProcessor.class.getName()};
    }
}
