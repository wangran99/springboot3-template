package com.laowang.springboot3template.constant;

//常用结果的枚举
public enum ResultEnum implements IResult {
    SUCCESS(1000, "接口调用成功"),
    AuthFailedOrExpired(1001,"user authorization failed or expired."),
    VALIDATE_FAILED(1002, "参数校验失败"),
    COMMON_FAILED(1003, "接口调用失败"),
    FORBIDDEN(1004, "没有权限访问资源");

    private Integer code;
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "Result { code=" + this.code + ", message=" + this.message + "}";
    }
}