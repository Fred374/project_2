package com.revature.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	//Custom method to facilitate login ( finding a User by username & password)
	public Optional<User> findByUserUsernameAndUserPassword(String username, String password);
	
}
