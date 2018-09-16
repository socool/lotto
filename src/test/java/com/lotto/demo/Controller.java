package com.lotto.demo;

import com.lotto.controller.response.AccountResponse;
import com.lotto.exception.MyAccountNotFoundException;

public class Controller{
    Repository repository;
    public void setRepository(Repository repository){
        this.repository = repository;
    }

    public AccountResponse getById(int id) throws MyAccountNotFoundException {
       return repository.getData(1);
    }
}
