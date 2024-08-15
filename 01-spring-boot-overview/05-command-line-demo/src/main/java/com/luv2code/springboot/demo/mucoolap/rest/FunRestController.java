package com.luv2code.springboot.demo.mucoolap.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachname;
    @Value("${team.name}")
    private String teamname;

    @GetMapping("/teaminfo")
    public String getTeaminfo(){

    return "Coach:" +coachname+ ",Team NAME"+ teamname;
    }

    @GetMapping("/")
    public String SayHello(){

        return "Hello World";
    }
    @GetMapping("/workout")
    public String SayWorkout(){
        return "Run a hard 5K!";
    }
    @GetMapping("/fortune")
    public String getdailyfortune(){
        return "today is your lucky day ";
    }


}
