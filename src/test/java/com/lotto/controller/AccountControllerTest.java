package com.lotto.controller;



import com.lotto.controller.response.AccountResponse;
import com.lotto.demo.Controller;
import com.lotto.demo.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Default SpringBootTest.WebEnvironment = MOCK
 * Integration test with start web server
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AccountControllerTest {
    /**
     * Can use RestTemplate instead.
     */
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void getById() {
        ResponseEntity<AccountResponse> response = this.testRestTemplate.getForEntity("/account/1",AccountResponse.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());

        AccountResponse expected = new AccountResponse("user","pass",10000);
        //should be implement equals and hashCode
        assertEquals(expected,response.getBody());

    }

    @Test
    public void getById2(){
        Repository repository = new StubRepository();
        Controller controller = new Controller();
        controller.setRepository(repository);
        AccountResponse actual = controller.getById(1);
        assertEquals("user",actual.getUserName());
        assertEquals("pass",actual.getPassword());
        assertEquals(10000,actual.getSalary());
    }
}
