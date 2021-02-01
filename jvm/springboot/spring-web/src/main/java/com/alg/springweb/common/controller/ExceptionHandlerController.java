package com.alg.springweb.common.controller;

import com.alg.springweb.common.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ValidationException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage exceptionHandler(ValidationException e) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.value(), e.getMessage());
    }
}
