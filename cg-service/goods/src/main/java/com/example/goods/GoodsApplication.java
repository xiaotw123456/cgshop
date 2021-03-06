package com.example.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 描述
 *
 * @author 三国的包子
 * @version 1.0
 * @package com.changgou *
 * @since 1.0
 */
@SpringBootApplication

@EnableEurekaClient

//注意 要使用通用的mapper的组件扫描
@MapperScan(basePackages = {"com.example.goods.dao"})
// mapper接口继承了通用的mapper
//默认提供一些方法:
//   insert
//   update

//  delete

//  select
//@EnableCaching
public class GoodsApplication {

    public static void main(String[] args) {

        SpringApplication.run(GoodsApplication.class, args);
    }


}
