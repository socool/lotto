package com.lotto.controller;

import com.lotto.exception.MyAccountNotFoundException;
import com.lotto.exception.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class AccountControllerExceptionHandler {

    @ExceptionHandler(MyAccountNotFoundException.class)
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ResponseException> accountNotFound(MyAccountNotFoundException exception){
        ResponseException responseException = new ResponseException();
        responseException.setMessage("Data not found");
        responseException.setTimestamp(new Date());
        return new ResponseEntity<ResponseException>(responseException,HttpStatus.NOT_FOUND);
    }

}
