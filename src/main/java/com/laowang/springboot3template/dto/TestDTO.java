package com.laowang.springboot3template.dto;

import lombok.Data;

@Data
public class TestDTO {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
}
