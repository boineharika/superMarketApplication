package com.learning.supermarket.freshmarket.controller;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learning.supermarket.freshmarket.entity.Role;
import com.learning.supermarket.freshmarket.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	RoleService roleService;
	@PostMapping("/addListOfNewRoles")
	public List<Role> addListOfNewRoles(@RequestBody List<Role> listOfRoles){
		List<Role> addlistOfnewRoles = roleService.addListOfNewRoles(listOfRoles);
		return addlistOfnewRoles;
	}
	/*@GetMapping("/getUserRoleById/{userId}")
	public Set<Role> getUserRoleById(@PathVariable("userId") int userId){
		Set<Role> newUser = roleService.getRoleByUserId(userId);
		return newUser;
	}*/
}
