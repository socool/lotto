package com.lotto.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotto.controller.response.AccountResponse;
import com.lotto.model.Account;
import com.lotto.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerWebMvcTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountRepository accountRepository;

    private JacksonTester<AccountResponse> jsonTester;

    @Test
    public void getByIdShouldReturnValidResponse() throws Exception {
        JacksonTester.initFields(this,new ObjectMapper());

        // Stub every time there call is always return all value
        Account account = new Account("user","pass",10000);
        given(accountRepository.findById(1))
                .willReturn(Optional.of(account));

        //MockMvcRequestBuilders.get
        MockHttpServletResponse response = mockMvc
                .perform(get("/account/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();
        assertEquals("Status should be 200",HttpStatus.OK.value(),response.getStatus());
        AccountResponse expected = new AccountResponse("user","pass",10000);
        assertEquals("Object should be equals"
                ,jsonTester.write(expected)
                        .getJson()
                ,response.getContentAsString());
    }

}