package com.yd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务消费者配置
 * 	Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单，
 * 	Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果
 * 	Feign是自带断路器的，在Dalston.RELEASE版本的Spring Cloud中，它没有默认打开。需要在配置文件中配置打开它
 * @author yuand
 *
 */
@SpringBootApplication
@EnableDiscoveryClient//把该服务消费者向服务中心注册
@EnableFeignClients//开启Feign的功能
//开启断路器的Hystrix 仪表@EnableHystrixDashboard，@EnableCircuitBreaker都要加，否则页面不显示
@EnableHystrixDashboard
@EnableCircuitBreaker
public class FeignConsumerApp {

	public static void main(String[] args){
        SpringApplication.run(FeignConsumerApp.class, args);
        System.out.println("App start ...");
    }
	
}
