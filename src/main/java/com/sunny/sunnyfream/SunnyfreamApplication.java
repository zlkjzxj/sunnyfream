package com.sunny.sunnyfream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Administrator
 */
@SpringBootApplication
@ComponentScan
@MapperScan(basePackages = "com.sunny.sunnyfream.mapper")
public class SunnyfreamApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunnyfreamApplication.class, args);
    }

}

