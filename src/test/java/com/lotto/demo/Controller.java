package com.lotto.demo;

import com.lotto.controller.response.AccountResponse;
import com.lotto.exception.MyAccountNotFoundException;
import com.lotto.model.Account;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.PostConstruct;
import java.util.Optional;

public class Controller{
    Repository repository;
    public void setRepository(Repository repository){
        this.repository = repository;
    }

    public AccountResponse getById(int id) throws MyAccountNotFoundException {
       return repository.getData(1);
    }
}
