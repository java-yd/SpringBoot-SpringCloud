package com.yd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 高可用的分布式配置中心，
 * @author yuand
 *
 */
@SpringBootApplication
@EnableEurekaServer//服务注册中心
public class EurekaServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceApp.class, args);
		System.out.println("configService  start...");
	}
}
