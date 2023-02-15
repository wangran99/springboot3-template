package com.laowang.springboot3template.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laowang.springboot3template.exception.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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
    @Autowired
    RedisTemplate redisTemplate;

    /**
     * 返回字符串
     *
     * @return 字符串类型
     */
    @GetMapping("hello")
    public String testString() {
        return "hello world.";
    }

    /**
     * 返回当前时间
     *
     * @return
     */
    @GetMapping("time")
    public LocalDateTime time() {
        LocalDateTime localDateTime = LocalDateTime.now();
        redisTemplate.opsForValue().set("ab",localDateTime);
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
     * 返回分页
     * @return
     */
    @GetMapping("/page")
    public IPage page() {
        IPage<LocalDateTime> page =new Page<>();
        return page;
    }

    /**
     * 返回异常
     *
     * @return
     */
    @GetMapping("exception")
    public String exception() {
        throw new ForbiddenException("没有权限，访问被拒绝");
    }
}
