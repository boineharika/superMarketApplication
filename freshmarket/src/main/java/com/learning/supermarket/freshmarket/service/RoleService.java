package com.learning.supermarket.freshmarket.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.supermarket.freshmarket.entity.Role;
import com.learning.supermarket.freshmarket.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	public List<Role> addListOfNewRoles(List<Role> roles ){
		List<Role> listOfNewRoles = roleRepository.saveAll(roles);
		return listOfNewRoles;
	}
	
	/*public Set<Role> getRoleByUserId(int userId) {
		Set<Role> userRole = roleRepository.findRoleByUserId(userId);
		return userRole;
	}*/
}
