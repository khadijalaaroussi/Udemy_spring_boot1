package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Override
    public void addAccount() {
        System.out.println(getClass()+ ":doing my db work : adding an account");
    }
}
