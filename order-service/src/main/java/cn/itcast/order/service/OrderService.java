package cn.itcast.order.service;

import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import com.hanser.feign.clients.UserClient;
import com.hanser.feign.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * @Description: RestTemplate 实现http远程调用
     * @Param:
     * @return:
     */
//    @Autowired
//    private RestTemplate restTemplate;
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2. 利用RestTemplate发起http请求,查询用户
////        String url = "http://localhost:8081/user/"+order.getUserId();  硬编码
//        String url = "http://userservice/user/"+order.getUserId();   //eureka  用服务名代替ip和端口
//        User user = restTemplate.getForObject(url, User.class);
//        // 3. 封装user到Order
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }

    @Autowired
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2. 利用Feign发起http请求,查询用户
        User user = userClient.findById(order.getUserId());
        // 3. 封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }
}
