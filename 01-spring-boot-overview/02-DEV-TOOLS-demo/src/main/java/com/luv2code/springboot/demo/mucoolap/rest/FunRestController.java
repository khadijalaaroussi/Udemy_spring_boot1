package com.luv2code.springboot.demo.mucoolap.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

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
