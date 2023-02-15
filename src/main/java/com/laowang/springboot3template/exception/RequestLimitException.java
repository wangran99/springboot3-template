package com.laowang.springboot3template.exception;


import com.laowang.springboot3template.constant.ResultEnum;

/**
 * 接口请求次数限制异常类
 */
public class RequestLimitException extends RuntimeException{

    public RequestLimitException() {
        super(ResultEnum.TOO_MANY_REQUESTS.getMessage());
    }
}
