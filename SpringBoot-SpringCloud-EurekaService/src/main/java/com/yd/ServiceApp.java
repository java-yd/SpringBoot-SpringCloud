package com.yd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //启动一个服务注册中心
public class ServiceApp {

	public static void main(String[] args){
        SpringApplication.run(ServiceApp.class, args);
        System.out.println("App start ...");
    }
}
