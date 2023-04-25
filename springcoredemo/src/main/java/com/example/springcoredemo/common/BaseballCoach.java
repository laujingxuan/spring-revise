package com.example.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("Baseball constructor");
    }
    @Override
    public String getDailyWorkOut(){
        return "Baseball Coach";
    }

    @PostConstruct
    public void doStartUpStuffs(){
        System.out.println("Start up code");
    }

    @PreDestroy
    public void doCleanUpStuffs(){
        System.out.println("Clean up code");
    }
}
