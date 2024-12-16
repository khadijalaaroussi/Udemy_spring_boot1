package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDao{


    @Override
    public Boolean addSillyMember() {
        System.out.println(getClass()+ ":doing my db work : adding an account");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() +":doing my db work : going to sleep");
    }
}
