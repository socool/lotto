package com.lotto.controller;

import com.lotto.controller.response.AccountResponse;
import com.lotto.model.Account;
import com.lotto.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class AccountControllerUnitTest2 {

    @Mock
    private AccountRepository repository;

    private AccountController accountController;

    @Before
    public void initial(){
        initMocks(this);
    }

    @Test
    public void getById() {
        /*
        accountController = new AccountController();
        AccountResponse accountResponse = accountController.getById(1);
        AccountResponse expected = null;
        assertEquals(expected,accountResponse);
        */

        //Stub
        Account account = new Account("user","pass",10000);
        given(repository.findById(1)).willReturn(Optional.of(account));

        accountController = new AccountController(repository);
        AccountResponse response = accountController.getById(1);
        AccountResponse expected = new AccountResponse("user","pass",10000);
        assertEquals(expected,response);
    }
}