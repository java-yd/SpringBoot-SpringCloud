package com.yd.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yd.service.UserService;

/**
 * 
 * @author yuand
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private   RestTemplate  restTemplate;

	/**
	 * @HystrixCommand:把断路路径指定到fallbackMethod
	 * 				当restTemplate.getForObject()无法访问(provider项目报错,controller层抛异常)会跳到指定断路路径
	 */
	@HystrixCommand(fallbackMethod="hystrixFindUser")
	public Object findUser() {
		//在这里我们直接用的程序名替代了具体的url地址，在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名
		Object forObject = restTemplate.getForObject("http://provider:9910/user", Object.class);
		System.out.println(forObject);
		return forObject;
	}
	
	public   Object  hystrixFindUser(){
		Map<String,Object>  map = new  HashMap<>();
		map.put("username", "hystrix");
		map.put("password", "123");
		return  map;
	}
}
