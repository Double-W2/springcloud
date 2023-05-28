package com.wxr.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean
    @LoadBalanced//ribbon LoadBalanced只要加上这个注解，就可以实现负载均衡算法
    public RestTemplate getRest(){
        return new RestTemplate();
    }
    /*配置负载均衡实现RestTemplate*/
}
