package com.laowang.springboot3template;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 根据数据库的字段自动生成对应的entity,mapper,service等，
 * 减少代码书写次数。需要在代码中设置连接的数据库地址，密码和项目的包名等信息
 *
 * @author WangRan
 */
public class CodeGenerator {
    private static final String URL = "jdbc:mysql://119.3.164.164:3306/db_datasync?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static final String USER_NAME = "noticeroot";
    private static final String PASSWORD = "Chinasoft#123notice";

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");

        FastAutoGenerator.create(URL, USER_NAME, PASSWORD)
                .globalConfig(builder -> {
                    builder.author("WangRan") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(projectPath + "/src/main/java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.laowang.springboot3template") // 设置父包名
//                            .moduleName("system") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, projectPath + "/src/main/resources/mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
//                    builder.addInclude("t_simple") // 设置需要生成的表名
//                            .addTablePrefix("t_", "c_"); // 设置过滤表前缀

                    builder.entityBuilder().enableLombok();
                    builder.controllerBuilder().enableRestStyle().enableHyphenStyle();
                    builder.mapperBuilder().enableBaseColumnList().enableBaseResultMap();
                })
                .templateConfig(builder -> {
                    //禁止除entiy的模板，只更新实体类
//                    builder.disable(TemplateType.CONTROLLER,TemplateType.MAPPER,TemplateType.SERVICE, TemplateType.SERVICEIMPL,TemplateType.XML);
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }

}
