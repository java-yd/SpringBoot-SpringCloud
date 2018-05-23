package com.yd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，
 * 比如／api/user转发到到user服务，/api/shop转发到到shop服务。
 * zuul默认和Ribbon结合实现了负载均衡的功能。
 * zuul不仅只是路由，并且还能过滤，做一些安全验证
 * @author yuand
 *
 */
@SpringBootApplication
@EnableZuulProxy//开启zuul的功能
@EnableEurekaClient
public class ZuulServiceApp {

	public static void main(String[] args) {
        SpringApplication.run(ZuulServiceApp.class, args);
        System.out.println("ZuulServiceApp  start...");
    }
}
