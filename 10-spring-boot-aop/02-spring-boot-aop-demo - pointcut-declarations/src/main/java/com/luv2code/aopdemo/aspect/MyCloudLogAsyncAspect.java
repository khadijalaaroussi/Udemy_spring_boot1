package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(12)
public class MyCloudLogAsyncAspect {
    @Before("com.luv2code.aopdemo.aspect.lUVaopexpressions.forDaoPackageNoGetterSetter()")
    public void logToCloudAsync(){
        System.out.println("\n=====>>>logging to cloud in async fashion ");


    }
}
