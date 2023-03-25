package com.hanser.feign.clients;

import com.hanser.feign.config.DefaultFeignConfiguration;
import com.hanser.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName: UserClient
 * @Description: 基于Feign的远程调用 for userservice
 * @author: zjh
 * @date: 2023/3/24  23:01
 * @Version: 1.0
 */

@FeignClient(value = "userservice",configuration = DefaultFeignConfiguration.class)
public interface UserClient {

    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}
