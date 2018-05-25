package com.yd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer // 开启配置服务器的功能
@EnableEurekaClient
public class EurekaConfigServiceApp {

	
	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigServiceApp.class, args);
		System.out.println("ConfigServiceApp   start...");
	}
}
