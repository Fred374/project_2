package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.UserDAO;
import com.revature.models.User;

@RestController
@RequestMapping(value="/user")
public class UserController {

	private UserDAO uDAO;

	// generated using fields
	@Autowired
	public UserController(UserDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}
	
	// Registering new user
	@PostMapping(value = "/register")
	// Request Body 'automatically' converts from JSON
	// All we need to learn is how to route the users input to here... simple enough to start
	// public ResponseEntity registerUser(@RequestBody Users u) {
	public ResponseEntity<User> registerUser(@RequestBody User u) {

		// test both of the options above
		
		// the save method is inserting the data collected from the request body
		// will I need control flow to see if the user entered 
		// correct info here before saving or...  
		// (most likely here. Why?)
		// newUser is what's being saved User object: u 
		// u is a User object representing the information the current 
		// non-user is attempting to register with
		
		// so before we save the information we need to evaluate aspects
		// of the User object u for password confirmation first
		User newUser = uDAO.save(u);
		
		// or here?
		if(newUser == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(newUser);
		// how do we limit this information to not show password? and then what 
	}
	
	// 
	 
}
