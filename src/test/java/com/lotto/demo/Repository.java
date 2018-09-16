package com.lotto.demo;

import com.lotto.controller.response.AccountResponse;

public interface Repository {
    public AccountResponse getData(int id);
}