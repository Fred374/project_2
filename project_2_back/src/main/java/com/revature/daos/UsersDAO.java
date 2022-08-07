package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.User;

public interface UsersDAO extends JpaRepository<User, Integer> {
	
}
