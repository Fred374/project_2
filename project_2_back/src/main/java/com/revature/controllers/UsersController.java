package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.UsersDAO;
import com.revature.models.Users;

@RestController
@RequestMapping(value="/user")
public class UsersController {

	private UsersDAO uDAO;

	// generated using fields
	@Autowired
	public UsersController(UsersDAO uDAO) {
		super();
		this.uDAO = uDAO;
	}
	
	@PostMapping(value = "/register")
	// Request Body 'automatically' converts from JSON
	// All we need to learn is how to route the users input to here... simple enough to start
	// public ResponseEntity registerUser(@RequestBody Users u) {
	public ResponseEntity<Users> registerUser(@RequestBody Users u) {

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
		Users newUser = uDAO.save(u);
		
		// or here?
		if(newUser == null) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.accepted().body(newUser);
		// how do we limit this information to not show password? and then what 
	}
	 
	
	 
	 
		
	
}
