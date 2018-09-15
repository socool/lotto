package com.lotto.controller;

import com.lotto.controller.response.AccountResponse;
import com.lotto.model.Account;
import com.lotto.repository.AccountRepository;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

public class AccountControllerUnitTest {

    private AccountController accountController;

    @Test
    public void getById() {
        accountController = new AccountController();
        AccountResponse accountResponse = accountController.getById(1);
        AccountResponse expected = null;
        assertEquals(expected,accountResponse);
    }
}