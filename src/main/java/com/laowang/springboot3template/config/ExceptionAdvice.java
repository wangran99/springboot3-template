package com.laowang.springboot3template.config;

import com.laowang.springboot3template.constant.Result;
import com.laowang.springboot3template.constant.ResultEnum;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//统一拦截异常
@RestControllerAdvice(basePackages = "com.laowang.springboot3template")
public class ExceptionAdvice {


    /**
     * {@code @RequestBody} 参数校验不通过时抛出的异常处理
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Result<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder sb = new StringBuilder("校验失败:");
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            sb.append(fieldError.getField()).append("：").append(fieldError.getDefaultMessage()).append(", ");
        }
        String msg = sb.toString();
        if (StringUtils.hasText(msg)) {
            return Result.fail(ResultEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION.getCode(), msg);
        }
        return Result.fail(ResultEnum.METHOD_ARGUMENT_NOT_VALID_EXCEPTION);
    }


    /**
     * 顶级异常捕获并统一处理，当其他异常无法处理时候选择使用
     */
    @ExceptionHandler({Exception.class})
    public Result<?> handle(Exception ex) {
        return Result.fail(ex.getMessage());
    }

}