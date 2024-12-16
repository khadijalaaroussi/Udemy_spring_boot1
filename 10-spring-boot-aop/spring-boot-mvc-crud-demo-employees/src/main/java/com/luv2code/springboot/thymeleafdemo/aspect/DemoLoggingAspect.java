package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


@Aspect
@Component
public class DemoLoggingAspect {
private Logger mylogger= Logger.getLogger(getClass().getName());

//setuo pointcut declarations
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.controller.*.*(..))")
    private void forControllerPACKAGE(){}


    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.dao.*.*(..))")
    private void forDaoPACKAGE(){}
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.*(..))")
    private void forServicePACKAGE(){}

    @Pointcut("forControllerPACKAGE()|| forDaoPACKAGE() || forServicePACKAGE()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){
        //display method we are calling
        String theMethod=theJoinPoint.getSignature().toShortString();
        mylogger.info("======>> in @Before:calling method" + theMethod);
        //display the argument to the method


        // get the arguments
        Object[]args =theJoinPoint.getArgs();

        //loop through and display args
        for (Object tempArg:args){
            mylogger.info("======>>argument: "+tempArg);
        }}

        //add @afterReturning advice
        @AfterReturning(
                pointcut = "forAppFlow()",
                returning = "theResult")
        public void afterReturning(JoinPoint theJoinPoint,Object theResult){


        //display method we are returning from

            String theMethod=theJoinPoint.getSignature().toShortString();
            mylogger.info("======>> in @afterReturning:from method" + theMethod);
       //display data returned
        mylogger.info("======>>result: " +theResult);




    }





}
