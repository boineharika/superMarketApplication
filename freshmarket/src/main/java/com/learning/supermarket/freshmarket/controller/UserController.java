package com.learning.supermarket.freshmarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.supermarket.freshmarket.entity.User;
import com.learning.supermarket.freshmarket.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/addListOfNewUsers")
	public List<User> addListOfNewUsers(@RequestBody List<User>users){
		List<User> listOfNewUsers = userService.addListOfNewUsers(users);
		return listOfNewUsers;
	}
	
	@PostMapping("/addNewUser")
	public User addNewUser(@RequestBody @Valid User user){
		User newUser = userService.addNewUser(user);
		return newUser;
	}
	
	@GetMapping("/getUserRoleById/{userId}")
	public List<String> getUserRoleById(@PathVariable("userId") Integer userId){
		List<String> newUser = userService.getRoleByUserId(Long.parseLong(userId.toString()));
		return newUser;
	}
}
