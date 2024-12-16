package com.luv2code.aopdemo;

import com.luv2code.aopdemo.Service.TrafficFortuneService;
import com.luv2code.aopdemo.dao.AccountDao;
import com.luv2code.aopdemo.dao.MembershipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDao theAccountDAO, MembershipDao theMembershipDao, TrafficFortuneService trafficFortuneService){

		return runner->{
			//demoTheBeforeAdvice(theAccountDAO,theMembershipDao);
			//demoTheAfterReturningAdvice(theAccountDAO);
			//demoTheAfterThrowingAdvice(theAccountDAO);
			//demoTheAfterAdvice(theAccountDAO);
			//demoTheAroundAdvice(trafficFortuneService);
			//demoTheAroundAdviceHandleException(trafficFortuneService);
			demoTheAroundAdvicerRethrowException(trafficFortuneService);
		};

	}

	private void demoTheAroundAdvicerRethrowException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdvicerRethrowException");
		System.out.println("calling getFortune()");
		boolean tripWire=true;
		String DATA =trafficFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is : "+DATA);
		System.out.println("Finished");
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("\n Main Program: demoTheAroundAdviceHandleException");
		System.out.println("calling getFortune()");
		boolean tripWire=true;
		String DATA =trafficFortuneService.getFortune(tripWire);
		System.out.println("\nMy fortune is : "+DATA);
		System.out.println("Finished");

	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {

		System.out.println("\n Main Program: demoTheAroundAdvice");
		System.out.println("calling getFortune()");
		String DATA =trafficFortuneService.getFortune();
		System.out.println("\nMy fortune is : "+DATA);
		System.out.println("Finished");



	}

	private void demoTheAfterAdvice(AccountDao theAccountDAO) {
		List<Account> theAccounts=null;

		try {
			//add a boolean flag to simulate the exception
			boolean tripWire=false;
			theAccounts=theAccountDAO.findAccounts(tripWire);
		}catch(Exception exc){
			System.out.println("\n \n Main program:... caught exception :"+exc);
		}
		//display the accounts
		System.out.println("\n \n Main program:demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterThrowingAdvice(AccountDao theAccountDAO) {

		List<Account> theAccounts=null;

		try {
			//add a boolean flag to simulate the exception
			boolean tripWire=true;
			theAccountDAO.findAccounts(tripWire);
		}catch(Exception exc){
			System.out.println("\n \n Main program:... caught exception :"+exc);
		}
		//display the accounts
		System.out.println("\n \n Main program:demoTheAfterThrowingAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheAfterReturningAdvice(AccountDao theAccountDAO) {
		// call method to find the accounts
		List<Account> theAccounts=theAccountDAO.findAccounts();
		//display the accounts
		System.out.println("\n \n Main program:demo theAfterReturningAdvice");
		System.out.println("-----");
		System.out.println(theAccounts);
		System.out.println("\n");
	}

	private void demoTheBeforeAdvice(AccountDao theAccountDAO,MembershipDao theMembershipDao) {
       Account myAccount = new Account();
	   myAccount.setName("madhu");
	   myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount,true);
		theAccountDAO.doWork();
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		String name=theAccountDAO.getName();
		String code=theAccountDAO.getServiceCode();


		theMembershipDao.addSillyMember();
		theMembershipDao.goToSleep();
		// do it again



	}

}
