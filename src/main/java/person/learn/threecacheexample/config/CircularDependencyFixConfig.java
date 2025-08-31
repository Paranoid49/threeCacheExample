package person.learn.threecacheexample.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircularDependencyFixConfig {

    @Bean
    public static BeanFactoryPostProcessor allowRawInjection() {
        return beanFactory -> {
            // 设置 allowRawInjectionDespiteWrapping 为 true
            ((AbstractAutowireCapableBeanFactory) beanFactory)
                    .setAllowRawInjectionDespiteWrapping(true);
        };
    }
}