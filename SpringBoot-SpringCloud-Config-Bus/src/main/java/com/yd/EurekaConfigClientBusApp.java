package com.yd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 在配置文件中将其注册到服务注册中心，作为Eureka客户端
 * Spring Cloud Bus 将分布式的节点用轻量的消息代理连接起来。
 * 它可以用于广播配置文件的更改或者服务之间的通讯，也可以用于监控
 * 如果git上配置文件修改，但是不想重启服务，可以访问
 * 	http://localhost:9963/bus/refresh
 * 因为9963这个服务集成mq，
 * 
 * 注意：
 * 	配置文件必须是bootstrap不能是application，否则报错
 * 	配置文件management.security.enabled必须设置false
 * 	类上面必须要添加@RefreshScope，
 * 		文档说必须加到使用到配置文件中的类，加到启动类没效果，但是目前启动类和目标类在一起，所以配置后正常，但是不配就不行了
 * @author yuand
 *
 */
@RefreshScope
@SpringBootApplication
@RestController
public class EurekaConfigClientBusApp {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigClientBusApp.class, args);
		System.out.println("configEurekaConfigClient start..");
	}
	
	
	@Value("${foo}")
    String foo;
    @RequestMapping(value = "/hello")
    public String hi(){
        return foo;
    }
}
