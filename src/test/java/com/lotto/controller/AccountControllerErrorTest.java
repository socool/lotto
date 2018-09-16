package com.lotto.controller;


import com.lotto.controller.response.AccountResponse;
import com.lotto.demo.Controller;
import com.lotto.demo.Repository;
import com.lotto.demo.StubRepository;
import com.lotto.exception.ResponseException;
import com.lotto.model.Account;
import com.lotto.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;

/**
 * Default SpringBootTest.WebEnvironment = MOCK
 * Integration test with start web server
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerErrorTest {
    /**
     * Can use RestTemplate instead.
     */
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private AccountRepository accountRepository;

    @Test
    public void getByIdWithAccountNotFound() {
        ResponseEntity<ResponseException> response = this.testRestTemplate.getForEntity("/account/2",ResponseException.class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());

        AccountResponse expected = new AccountResponse("user","pass",10000);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        assertEquals("Data not found",response.getBody().getMessage());
        assertNotNull(response.getBody().getTimestamp());

    }
}
