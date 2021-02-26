package com.learning.supermarket.freshmarket.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.supermarket.freshmarket.entity.Role;
import com.learning.supermarket.freshmarket.entity.User;
import com.learning.supermarket.freshmarket.repository.RoleRepository;
import com.learning.supermarket.freshmarket.repository.UsersRepository;
@Service
public class UserService {

	@Autowired
	UsersRepository usersRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public List<User> addListOfNewUsers(List<User> users) {
		List<User> listOfNewUsers = usersRepository.saveAll(users);
		return listOfNewUsers;
	}

	public User addNewUser(User user) {
		String actualTextPassword = user.getPassword();
		String encryptPassword = bCryptPasswordEncoder.encode(actualTextPassword);
		user.setPassword(encryptPassword);
		Role role = roleRepository.findById((long) 3).get();
		Set<Role> roles = new HashSet();
		roles.add(role);
		user.setRoles(roles);
		user.setActive(true);
		User newUser = usersRepository.save(user);
		return newUser;
	}
	
	public List<String> getRoleByUserId(long userId) {
		Optional<User> user = usersRepository.findById(userId);
		if(user.isPresent()) {
			List<String> roleList = new ArrayList();
			Set<Role> userRole = user.get().getRoles();
			for (Role role : userRole) {
				roleList.add(role.getRole());
			}
			return roleList;
		}else {
			return null;
		}
		
	}

	public User findUserByUserName(String userName) {
		User user = usersRepository.findByUserName(userName);
		return user;
	}
}
