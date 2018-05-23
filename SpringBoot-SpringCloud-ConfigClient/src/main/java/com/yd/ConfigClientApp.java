package com.yd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author yuand
 *
 */
@SpringBootApplication
@RestController
public class ConfigClientApp {

	public static void main(String[] args) {
        SpringApplication.run(ConfigClientApp.class, args);
        System.out.println("ConfigClientApp start...");
    }

    @Value("${foo}")
    String foo;
    @RequestMapping(value = "/hello")
    public String hi(){
        return foo;
    }
}
