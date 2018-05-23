package com.yd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  //创建一个服务提供者 
public class ProviderApp {

	public static void main(String[] args){
        SpringApplication.run(ProviderApp.class, args);
        System.out.println("App start ...");
    }
}
