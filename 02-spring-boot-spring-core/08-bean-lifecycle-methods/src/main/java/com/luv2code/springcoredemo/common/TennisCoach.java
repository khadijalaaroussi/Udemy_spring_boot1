package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "PRACTICE YOUR BACHAND VOLLEY";
    }

    public TennisCoach() {
        System.out.println("In constructor:"+getClass().getSimpleName());
    }
}
