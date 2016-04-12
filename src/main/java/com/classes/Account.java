package com.classes;

/**
 * Created by marce on 4/12/2016.
 */
public class Account {
    private String accountNumber;
    private String accountOwnerCpf;
    private String accountOwnerName;

    public Account(String accountNumber, String accountOwnerCpf, String accountOwnerName){
        this.accountNumber = accountNumber;
        this.accountOwnerCpf = accountOwnerCpf;
        this.accountOwnerName = accountOwnerName;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public String getAccountOwnerCpf(){
        return accountNumber;
    }

    public String getAccountOwnerName(){
        return accountNumber;
    }
}
