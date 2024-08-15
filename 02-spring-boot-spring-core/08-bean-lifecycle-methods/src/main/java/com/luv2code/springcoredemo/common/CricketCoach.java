package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor:"+getClass().getSimpleName());
    }
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In postConstruct:"+getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In predestroy:"+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice  fast bowling for 15 minutes ";
    }
}
