package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserRoleDAO;
import com.revature.models.UserRole;

@RestController
@RequestMapping(value="/user_role")
public class UserRoleController {
	
	private UserRoleDAO urDAO;

	@Autowired
	public UserRoleController(UserRoleDAO urDAO) {
		super();
		this.urDAO = urDAO;
	}
	
	@GetMapping
	public ResponseEntity<List<UserRole>> getAllUserRoles() {
		return ResponseEntity.ok(urDAO.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserRole> findUserRoleById(@PathVariable int id) {
		
		Optional<UserRole> userRoleOptional = urDAO.findById(null);
		
		if (userRoleOptional.isPresent()) {
			UserRole userRole = userRoleOptional.get();
			return ResponseEntity.ok(userRole);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<UserRole> addUserRole(@RequestBody UserRole userRole) {
		
		UserRole newUserRole = urDAO.save(userRole);
		
		if (newUserRole != null) {
			return ResponseEntity.accepted().body(newUserRole);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
	
	// NEED to add update with @PutMapping
}
