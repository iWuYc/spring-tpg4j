package com.iwuyc.tpg4j.spring.core.config;

import com.iwuyc.tools.commons.util.collection.MapUtil;
import com.iwuyc.tools.commons.util.file.FileUtil;
import com.iwuyc.tpg4j.Tpg4jConfig;
import com.iwuyc.tpg4j.interfaces.Tpg4jService;
import com.iwuyc.tpg4j.spring.core.dto.Tpg4jAnnotationInfo;
import com.iwuyc.tpg4j.spring.core.exception.Tpg4jDependenciesException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Tpg4jConfigPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        try {
            final Tpg4jAnnotationInfo tpg4jAnnotationInfo = Tpg4jConfigSelector.TPG_4_J_ANNOTATION_INFO_COMPLETABLE_FUTURE.get(1, TimeUnit.MINUTES);
            final Class<?>[] dependencies = tpg4jAnnotationInfo.getDependencies();
            for (Class<?> dependency : dependencies) {
                final Map<String, ?> beansOfType = beanFactory.getBeansOfType(dependency);
                if (MapUtil.isEmpty(beansOfType)) {
                    throw new Tpg4jDependenciesException("缺少必要的依赖服务[" + dependency.getName() + "]");
                }
            }
            String configPath = tpg4jAnnotationInfo.getConfigPath();
            final String absoluteLocation = FileUtil.absoluteLocation(configPath);
            final Tpg4jService threadPoolService = Tpg4jConfig.config(absoluteLocation);
            beanFactory.registerSingleton("tpg4jService", threadPoolService);
        } catch (TimeoutException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
