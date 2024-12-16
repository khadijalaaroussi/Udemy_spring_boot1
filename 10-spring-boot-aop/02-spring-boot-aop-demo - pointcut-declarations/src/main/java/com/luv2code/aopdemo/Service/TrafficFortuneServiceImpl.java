package com.luv2code.aopdemo.Service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl  implements TrafficFortuneService{
    @Override
    public String getFortune() {
        //SIMULATE A DELAY
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        // RETURN A FORTUNE

        return "Expect heavy traffic this morning";
    }

    @Override
    public String getFortune(boolean tripWire) {
       if(tripWire){
           throw new RuntimeException("Major accident! highway is closed!");
       }
       return getFortune();
    }
}
