package com.hanser.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName: EurekaApplication
 * @Description: TODO
 * @author: zjh
 * @date: 2023/3/22  21:32
 * @Version: 1.0
 */

@EnableEurekaServer   //实现自动装配
@SpringBootApplication
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
