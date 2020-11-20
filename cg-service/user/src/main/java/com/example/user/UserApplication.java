package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @version: V1.0
 * @author: Administrator
 * @className: UserApplication
 * @packageName: com.example.user
 * @description: 这是用户类
 * @data: 2020/10/26 18:54
 **/
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.example.user.dao")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
