package com.lotto.repository;

import com.lotto.model.Account;
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

    @Test
    public void createNewAccount(){
        Account account = new Account("user","password",10000);
        Account actualAccount = accountRepository.save(account);
        logger.info("Save ID:"+actualAccount.getId());
        assertEquals(1,actualAccount.getId());
        assertEquals(1,accountRepository.count());
    }

    @Test
    public void createNewAccount2(){
        Account account = new Account("user","password",10000);
        Account account2 = new Account("user","password",10000);

        accountRepository.save(account);
        accountRepository.save(account2);

        assertEquals(2,accountRepository.count());
    }
}