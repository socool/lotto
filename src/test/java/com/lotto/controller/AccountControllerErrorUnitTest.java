package com.lotto.controller;

import com.lotto.controller.response.AccountResponse;
import com.lotto.exception.MyAccountNotFoundException;
import com.lotto.model.Account;
import com.lotto.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerErrorUnitTest {

    @Mock
    private AccountRepository repository;

    private AccountController accountController;

    @Test(expected = MyAccountNotFoundException.class)
    public void getByIdWithException() {
        //Stub
        given(repository.findById(2))
                .willReturn(Optional.empty());
        // .willThrow(new MyAccountNotFoundException("failed case"));

        accountController = new AccountController(repository);
        AccountResponse response = accountController.getById(2);
    }
}