package com.mscomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mscomm.feignconfig.UserRestConsumer;
import com.mscomm.model.User;

@RestController
@RequestMapping("/path")
public class UserFeignController {

	@Autowired
	private UserRestConsumer uconsumer;
	
	@GetMapping("/userbyid/{uid}")
	public User getUserInfoById(@PathVariable int uid)
	{
		return uconsumer.getUserByIdHandler(uid);
	}
	
	@GetMapping("/allusers")
	public List<User> getUserInfo()
	{
//		List<User> uobj = uconsumer.getAllUsersHandler(); 
		return uconsumer.getAllUsersHandler1();
	}
}