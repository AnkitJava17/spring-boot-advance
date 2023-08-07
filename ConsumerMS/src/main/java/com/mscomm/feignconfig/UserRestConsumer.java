package com.mscomm.feignconfig;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mscomm.model.User;

@FeignClient(name="user-service")
public interface UserRestConsumer 
{
	@GetMapping("/user/v1/getuserbyid/{uid}")
	public User getUserByIdHandler(@PathVariable int uid);
	
	@GetMapping("/user/v1/getAllusers")
	public List<User> getAllUsersHandler1();

}
