package com.lotto.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lotto.controller.response.AccountResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerSpringBootMockTest {
    @Autowired
    private MockMvc mockMvc;

    private JacksonTester<AccountResponse> jsonTester;

    @Test
    public void getByIdShouldReturnValidResponse() throws Exception {
        JacksonTester.initFields(this,new ObjectMapper());
        //MockMvcRequestBuilders.get
        MockHttpServletResponse response = mockMvc
                .perform(get("/account/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();
        assertEquals("Status should be 200",HttpStatus.NOT_FOUND,response.getStatus());
        AccountResponse expected = new AccountResponse("user","pass",10000);
        assertEquals("Object should be equals"
                ,jsonTester.write(expected)
                .getJson()
                ,response.getContentAsString());
    }
}