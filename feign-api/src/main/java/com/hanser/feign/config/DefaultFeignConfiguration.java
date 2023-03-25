package com.hanser.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName: DefaultFeignConfiguration
 * @Description: Feign的日志级别配置
 * @author: zjh
 * @date: 2023/3/25  22:29
 * @Version: 1.0
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level getLogLevel(){
        return Logger.Level.BASIC;
    }
}
