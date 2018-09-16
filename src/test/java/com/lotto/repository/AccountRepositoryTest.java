package com.lotto.repository;

import com.lotto.model.Account;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Test MongoDB with @DataMongoTest
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountRepository accountRepository;

    @After
    public void setUp() throws Exception {
        // Clear all data for test
        accountRepository.deleteAll();
        logger.info("############# RUN SETUP ###############");
    }

    @Test
    public void createNewAccount(){
        Account account = new Account("user","password",10000);
        Account actualAccount = accountRepository.save(account);
        logger.info("Save ID:"+actualAccount.getId()+" Length:"+accountRepository.count());
        //assertEquals(1,actualAccount.getId());
        assertEquals(1,accountRepository.count());
    }

    @Test
    public void createNewAccount2(){
        Account account = new Account("user1","password1",12000);
        Account account2 = new Account("user2","password2",13000);

        accountRepository.save(account);
        accountRepository.save(account2);

        assertEquals(2,accountRepository.count());
    }
}