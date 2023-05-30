package com.wxr.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {
    @Bean
    @LoadBalanced//ribbon LoadBalanced只要加上这个注解，就可以实现负载均衡算法，默认实现轮询。
    public RestTemplate getRest(){
        return new RestTemplate();
    }
    /*配置负载均衡实现RestTemplate*/

    /*修改负载均衡的算法，这是针对任何微服务而言（也可以在配置文件中配置单一微服务的规则）。如果要自定义，就要继承AbstractLoadBalancerRule类，实现里面的方法即可。*/
    @Bean
    public IRule getRandomRule(){
        return new RandomRule();
    }

}
