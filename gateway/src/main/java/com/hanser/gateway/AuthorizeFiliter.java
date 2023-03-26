package com.hanser.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName: AuthorizeFiliter
 * @Description: 自定义网关全局过滤器（用于登录认证）
 * @author: zjh
 * @date: 2023/3/26  22:18
 * @Version: 1.0
 */

@Order(-1)  //定义过滤器执行的优先级（越小优先级越高）
@Component
public class AuthorizeFiliter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1. 获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> params = request.getQueryParams();
        //2.获取参数中的 authorization 参数
        String auth = params.getFirst("authorization");
        //3. 判断参数值是否等于admin
        if("admin".equals(auth)){
            // 放行
            return chain.filter(exchange);
        }
        //否,拦截
        //   设置状态码，让用户体验更友好
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

        return exchange.getResponse().setComplete();
    }
}
