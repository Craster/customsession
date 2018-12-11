package com.example.sessiontest;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppContext {

    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new MySessionScopeBeanFactoryPostProcessor();
    }

    @Bean
    @Scope("bot")
    public TestService testService() {
        return new TestService();
    }
}
