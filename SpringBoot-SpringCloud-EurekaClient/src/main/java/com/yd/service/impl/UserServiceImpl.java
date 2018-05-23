package com.yd.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yd.service.UserService;

/**
 * 
 * @author yuand
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Override
	public Object findUser() {
		Map<String,String>  map = new  HashMap<>();
		map.put("username", "张三");
		map.put("password", "123");
		return map;
	}

}
