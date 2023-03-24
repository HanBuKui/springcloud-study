package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Properties
 * @Description: nacos配置文件读取
 * @author: zjh
 * @date: 2023/3/24  22:22
 * @Version: 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "pattern")  //用@ConfigurationProperties 读取nacos配置可以做到热更新
public class Properties {
    private String dateformat;
    private String envSharedValue;

}
