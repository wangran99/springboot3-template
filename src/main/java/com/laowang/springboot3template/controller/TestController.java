package com.laowang.springboot3template.controller;

import com.laowang.springboot3template.exception.ForbiddenException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * 测试controller
 */
@RestController
@RequestMapping("/test")
public class TestController {

    /**
     * 返回字符串
     * @return 字符串类型
     */
    @GetMapping("hello")
    public String testString() {
        return "hello world.";
    }

    /**
     * 返回当前时间
     * @return
     */
    @GetMapping("time")
    public LocalDateTime time() {
        LocalDateTime localDateTime= LocalDateTime.now();
        return localDateTime;
    }

    @GetMapping("/sleep")
    public String sleep() {
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "sleep ok.";
    }

    /**
     * 返回异常
     * @return
     */
    @GetMapping("exception")
    public String exception() {
        throw  new ForbiddenException("没有权限，访问被拒绝");
    }
}
