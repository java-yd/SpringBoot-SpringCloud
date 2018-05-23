package com.yd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yd.service.UserService;

/**
 * 
 * @author yuand
 *
 */
@RestController
@RequestMapping
public class UserController {

	@Autowired
	private   UserService   userService;
	
	@RequestMapping(value="user",method=RequestMethod.GET)
	private  Object   getUser(){
//		int   i = 0/0;   
//		int  i = 0;
//		if(i == 0){
//			throw  new  RuntimeException("抛异常");
//		}
		return   userService.findUser();
	}
}
