package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public class lUVaopexpressions {

    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.*(..))")
   public void forDaoPackage(){}
    //@Before("execution(public void add*())")

    //create a pointcut for getter methods
    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.get*(..))")
    public void getter(){}
    //create a pointcut for setter methods
    @Pointcut("execution( * com.luv2code.aopdemo.dao.*.set*(..))")
    public void setter(){}
    //create pointcut:include pachage exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}
}
