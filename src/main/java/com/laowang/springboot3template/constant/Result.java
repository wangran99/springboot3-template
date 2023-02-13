package com.laowang.springboot3template.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回结果返回对象
 *
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> success(String message, T data) {
        return new Result<>(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public static Result<?> fail() {
        return new Result<>(ResultEnum.OPERATION_ERRO.getCode(), ResultEnum.OPERATION_ERRO.getMessage(), null);
    }

    public static Result<?> fail(String message) {
        return new Result<>(ResultEnum.OPERATION_ERRO.getCode(), message, null);
    }

    public static Result<?> fail(IResult errorResult) {
        return new Result<>(errorResult.getCode(), errorResult.getMessage(), null);
    }

    public static Result<?> fail(Integer code, String message) {
        return new Result<>(code, message, null);
    }

    public static <T> Result<T> instance(Integer code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}