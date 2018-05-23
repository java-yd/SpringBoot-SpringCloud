package com.yd.service.hystric;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.yd.service.UserService;

/**
 * Feign中使用断路器,需要实现指定的feign接口，并添加到spring容器中
 * @author yuand
 *
 */
@Component
public class UserServiceHystric implements  UserService{

	@Override
	public Object findUser() {
		Map<String,Object>  map = new  HashMap<>();
		map.put("username", "feignHystric");
		map.put("password", "123");
		return map;
	}

}
