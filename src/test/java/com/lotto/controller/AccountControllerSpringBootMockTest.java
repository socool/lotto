package com.lotto.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerSpringBootMockTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getById() throws Exception {
        //MockMvcRequestBuilders.get
        MockHttpServletResponse response = mockMvc
                .perform(get("/account/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
}