package com.learning.supermarket.freshmarket.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.supermarket.freshmarket.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	//Set<Role> findRoleByUserId(int userId);
}
