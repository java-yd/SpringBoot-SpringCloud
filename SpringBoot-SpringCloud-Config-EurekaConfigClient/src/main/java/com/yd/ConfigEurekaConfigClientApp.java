package com.yd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在配置文件中将其注册到服务注册中心，作为Eureka客户端
 * @author yuand
 *
 */
@SpringBootApplication
@RestController
public class ConfigEurekaConfigClientApp {

	public static void main(String[] args) {
		SpringApplication.run(ConfigEurekaConfigClientApp.class, args);
		System.out.println("configEurekaConfigClient start..");
	}
	
	
	@Value("${foo}")
    String foo;
    @RequestMapping(value = "/hello")
    public String hi(){
        return foo;
    }
}
