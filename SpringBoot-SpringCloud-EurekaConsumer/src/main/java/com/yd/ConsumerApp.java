package com.yd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient  //把该服务消费者向服务中心注册
@EnableHystrix//开启Hystrix断路器
@EnableHystrixDashboard//开启断路器的hystrix的仪表器，页面方便查看
public class ConsumerApp {

	
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApp.class, args);
		System.out.println("Consumer APP  start....");
	}
	
	
	@Bean
    @LoadBalanced//注解表明这个restRemplate开启负载均衡的功能
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
