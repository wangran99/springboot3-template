package com.itarge.antiepidemic.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * mybatis-plus 配置类:插件配置，包括分页查询和动态表名插件，其他插件参见官网
 */
@Configuration
@MapperScan("com.laowang.springboot3template.mapper")
public class MyBatisPlusConfig {
    /**
     * 配置mybatis-plus 分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //配置mybatis-plus 分页查件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));//指定数据库
        return interceptor;
    }
}