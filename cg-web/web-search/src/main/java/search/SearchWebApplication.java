package search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version: V1.0
 * @author: Administrator
 * @className: SearchWebApplication
 * @packageName: com.cgou.search
 * @description: 这是用户类
 * @data: 2020/11/2 13:19
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.example.search.feign")
public class SearchWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchWebApplication.class,args);
    }
}
