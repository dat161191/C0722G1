package com.example.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerController {
    @ExceptionHandler(NullPointerException.class)
    public String handlerNullPointer(){
        return "errorPage";
    }
    @ExceptionHandler(Exception.class)
    public String handlerException(){
        return "errorPage1";
    }
}
