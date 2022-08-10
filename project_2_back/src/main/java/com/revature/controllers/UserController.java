package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.UserDAO;
import com.revature.daos.UserRoleDAO;
import com.revature.models.User;
import com.revature.models.UserRole;

@RestController
@RequestMapping(value="/user")
public class UserController {

	private UserDAO uDAO;
	private UserRoleDAO urDAO;

	// generated using fields
	@Autowired
	public UserController(UserDAO uDAO, UserRoleDAO urDAO) {
		super();
		this.uDAO = uDAO;
		this.urDAO = urDAO;
	}
	
	// Getting all Users
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(uDAO.findAll());
	}
	
	// Getting User by ID
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findUserRoleById(@PathVariable int id) {
		Optional<User> userOptional = uDAO.findById(id);
		
		if (userOptional.isPresent()) {
			User user = userOptional.get();
			return ResponseEntity.ok(user);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	// Adding (registering) new user
	@PostMapping(value = "/register/{roleId}")
	// Request Body 'automatically' converts from JSON

	public ResponseEntity<User> registerUser(@RequestBody User passedUser, @PathVariable int roleId) {

		Optional<UserRole> userRoleOptional = urDAO.findById(roleId);

		if(userRoleOptional.isPresent()) {
			
			// Getting user role and adding it to the passed user object 
			UserRole userRoleId = userRoleOptional.get();
			passedUser.setUserRoleId(userRoleId);
		
			// Saving the new user to DB
			User newUser = uDAO.save(passedUser);
			
			if(newUser != null) {
				return ResponseEntity.accepted().body(newUser);
			}
		}
		
		return ResponseEntity.badRequest().build();
		
		// how do we limit this information to not show password? and then what 
	}
	 
}