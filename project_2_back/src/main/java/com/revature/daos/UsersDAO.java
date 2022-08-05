package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Users;

public interface UsersDAO extends JpaRepository<Users, Integer> {
	
	

}
