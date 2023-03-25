package cn.itcast.order;

import com.hanser.feign.clients.UserClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableFeignClients(clients = UserClient.class) //指定加载哪个客户端（因为原本不在这个类的扫描范围内）  //feign的自动装配开关
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }


//    @Bean
//    @LoadBalanced  //负载均衡
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }


}