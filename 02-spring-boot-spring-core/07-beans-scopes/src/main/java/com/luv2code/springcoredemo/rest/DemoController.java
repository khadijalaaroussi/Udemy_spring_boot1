package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {


   private Coach anotherCoach;
    private Coach myCoach;
    @Autowired
    public  DemoController(@Qualifier("cricketCoach") Coach theCoach,@Qualifier("cricketCoach") Coach theotherCoach){
        System.out.println("In constructor:"+getClass().getSimpleName());
    myCoach=theCoach;
    anotherCoach=theotherCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        return "comparing beans:mycoach==anotherCoach,"+(myCoach==anotherCoach);
    }

}
