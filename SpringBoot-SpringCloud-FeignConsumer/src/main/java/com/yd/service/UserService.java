package com.yd.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yd.service.hystric.UserServiceHystric;


@FeignClient(value="provider",fallback=UserServiceHystric.class)
public interface UserService {
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	Object   findUser();
}
