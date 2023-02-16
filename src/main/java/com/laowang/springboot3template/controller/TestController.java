package com.laowang.springboot3template.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laowang.springboot3template.dto.TestDTO;
import com.laowang.springboot3template.exception.ForbiddenException;
import com.laowang.springboot3template.exception.RequestLimitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

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
        redisTemplate.opsForValue().set("ab", localDateTime);
        return localDateTime;
    }

    /**
     * 测试sleep
     *
     * @return
     */
    @GetMapping("/sleep")
    public String sleepTest() {
        try {
            Thread.sleep(25);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "sleep ok.";
    }

    /**
     * 返回分页
     *
     * @return
     */
    @GetMapping("/page")
    public IPage page() {
        IPage<LocalDateTime> page = new Page<>();
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

    /**
     * 添加json格式接口
     *
     * @param testDTO
     * @return
     */
    @PostMapping("add")
    public String add(@RequestBody TestDTO testDTO) {
        return "add successful.";
    }

    /**
     * 测试json返回
     *
     * @return
     */
    @GetMapping("json")
    public TestDTO addJson() {
        TestDTO testDTO = new TestDTO();
        testDTO.setUserName("王二");
        testDTO.setEmail("hello@163.com");
        testDTO.setPassword("123456");
        return testDTO;
    }

    /**
     * 测试返回异常
     */
    @GetMapping("limitexception")
    public void newException() {
        throw new RequestLimitException();
    }
}
