package com.lotto.demo;


import com.lotto.controller.response.AccountResponse;
import com.lotto.model.Account;

public class StubRepository implements Repository {
    public AccountResponse getData(int id){
        Account account = new Account("user","pass",10000);;
        return new AccountResponse(account.getUsername(),account.getPassword(),account.getSalary());
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}