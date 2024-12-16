package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(-2)
public class MyDemoLoggingAspect {
    @Around("execution(* com.luv2code.aopdemo.Service.*.getFortune(..))")
   public Object aroundGetFortune(
           ProceedingJoinPoint proceedingJoinPoint
   )throws Throwable{
        //print out method we are advising on
        String method=proceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @Around on method " +method);

        //get begin timestamp
  long begin=System.currentTimeMillis();

        //now let's execute the method
  Object result=null;
    try {
        result=proceedingJoinPoint.proceed();
    }catch(Exception exc){
        System.out.println(exc.getMessage());
        //result="major accident but no worries your private aop helicopter is on the way!";
        //rethrow exception
        throw exc;
    }
        //get end timestamp
        long end=System.currentTimeMillis();

        //compute duration and display it
        long duration=end-begin;
        System.out.println("\n======>Duration:"+duration/1000.0+"seconds");

       return result;
   }



@After("execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint){
    String method=joinPoint.getSignature().toShortString();
    System.out.println("\n=======>>> Executing @After (finally) on method " +method);
    }


  @AfterThrowing(
          pointcut ="execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
                  throwing="theExc"
  )
    public void AfterThrowingFindAccountsAdvice(JoinPoint joinPoint,Throwable theExc){
      String method=joinPoint.getSignature().toShortString();
      System.out.println("\n=======>>> Executing @AfterTHROWING on method " +method);

      System.out.println("\n=======>>> THE exception is " +theExc);
    }


    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){
      // print out which method we are advising on
        String method=joinPoint.getSignature().toShortString();
        System.out.println("\n=======>>> Executing @AfterReturning on method " +method);

        //print out the results of the method call
        System.out.println("\n=======>>> result is " +result);

        // let's post-process the data ....let's modify it :-)

        //convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
        System.out.println("\n=======>>> result is " +result);

    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        //loop through accounts
        for (Account tempAccount : result) {

            //get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            //update the name on the account
            tempAccount.setName(theUpperName);
        }
    }

    @Before("com.luv2code.aopdemo.aspect.lUVaopexpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
    System.out.println("\n=====>>> Executing @Before advice on method");
//display the method signature
        MethodSignature methodSignature=(MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: "+methodSignature);
// display method arguments
        Object[] args=theJoinPoint.getArgs();

        //loop through args

        for(Object tempArg:args){
            System.out.println(tempArg);
//downcast and print account specific stuff
            if(tempArg instanceof Account){
                Account theAccount=(Account) tempArg;
                System.out.println("account name:"+theAccount.getName());
                System.out.println("account name:"+theAccount.getLevel());

            }
        }



}

}




