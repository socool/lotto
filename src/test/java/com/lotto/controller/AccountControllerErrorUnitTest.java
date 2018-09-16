package com.lotto.controller;

import com.lotto.controller.response.AccountResponse;
import com.lotto.exception.MyAccountNotFoundException;
import com.lotto.model.Account;
import com.lotto.repository.AccountRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

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

        //when(repository.findById(null)).thenReturn(Optional.empty());

        accountController = new AccountController(repository);
        AccountResponse response = accountController.getById(2);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getByIdWithExceptionWithRule() {
        //Stub
        when(repository.findById(2))
                .thenReturn(Optional.empty());

        accountController = new AccountController(repository);

        thrown.expect(MyAccountNotFoundException.class);
        thrown.expectMessage("Account id=[2] not found");

        AccountResponse response = accountController.getById(2);
    }
}