package com.lotto.controller;

import com.lotto.controller.response.AccountResponse;
import com.lotto.exception.MyAccountNotFoundException;
import com.lotto.model.Account;
import com.lotto.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    public AccountController(AccountRepository repository){
        this.accountRepository = repository;
    }

    /**
     * Spring handle runtime exception for us
     * @param id
     * @return
     * @throws MyAccountNotFoundException
     */
    @GetMapping("/account/{id}")
    public AccountResponse getById(@PathVariable int id) throws MyAccountNotFoundException {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            Account myAccount = account.get();
            return new AccountResponse(myAccount.getUsername(),myAccount.getPassword(),myAccount.getSalary());
        }
        throw new MyAccountNotFoundException(
                String.format("Account id=[%d] not found",id));
    }


    @PostConstruct
    public void initData(){
        Account account = new Account("user","pass",10000);
        accountRepository.save(account);

    }
}
