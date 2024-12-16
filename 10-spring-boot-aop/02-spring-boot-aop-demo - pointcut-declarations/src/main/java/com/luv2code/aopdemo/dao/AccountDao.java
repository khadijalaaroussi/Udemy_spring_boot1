package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;

import java.util.List;

public interface AccountDao {
    // add a new method:findAccounts()
    List<Account> findAccounts();
    void addAccount(Account theAccount,boolean vipFlag);
    boolean doWork();
    public void setName(String name);
    public String getName();
    public String getServiceCode();
    public void setServiceCode(String serviceCode);


    List<Account> findAccounts(boolean tripWire);
}
