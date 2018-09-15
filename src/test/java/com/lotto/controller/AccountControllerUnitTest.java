package com.lotto.controller;

import com.lotto.controller.response.AccountResponse;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountControllerUnitTest {

    private AccountController accountController;

    @Test
    public void getById() {
        accountController = new AccountController();
        AccountResponse accountResponse = accountController.getById(1);
        AccountResponse expected = new AccountResponse("user","pass",10000);
        assertEquals(expected,accountResponse);
    }
}