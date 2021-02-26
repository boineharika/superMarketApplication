package com.learning.supermarket.freshmarket.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.learning.supermarket.freshmarket.entity.Role;
import com.learning.supermarket.freshmarket.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

	User findByUserName(String userName);

	//Set<Role> findRolesByUserId(int userId);
	
	/*@Query(value = "SELECT role_id FROM user_role where user_id="+userId+";", nativeQuery=true)
	public List<Role> getAllLastName(int userId);*/
	
	/*@Query(value = "SELECT role FROM user_role where user_id="+userId+";", nativeQuery=true)
	public List<Role> getRolesByUserId(int userId);*/
}
