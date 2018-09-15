package com.lotto.controller.response;

import javax.swing.*;

public class AccountResponse {
    private String userName;
    private String password;
    private int salary;

    /**
     * Spring generate json need default constructor.
     */
    public AccountResponse(){

    }

    public AccountResponse(String userName, String password, int salary) {
        this.setUserName(userName);
        this.setPassword(password);
        this.setSalary(salary);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
