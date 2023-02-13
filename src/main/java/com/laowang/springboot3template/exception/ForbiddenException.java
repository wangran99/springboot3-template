package com.laowang.springboot3template.exception;

//自定义异常
public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}
