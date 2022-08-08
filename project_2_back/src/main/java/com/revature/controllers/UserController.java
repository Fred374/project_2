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
import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.models.UserRole;

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
	@PostMapping(value = "/register")
	// Request Body 'automatically' converts from JSON
	// All we need to learn is how to route the users input to here... simple enough to start
	// public ResponseEntity registerUser(@RequestBody Users u) {
	public ResponseEntity<User> registerUser(@RequestBody User u) {

		// test both of the options above
		
		// the save method is inserting the data collected from the request body
		// will I need control flow to see if the user entered 
		// correct info here before saving or...  //ADDED by VAHE - maybe we can do it in the front end?
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
	 
}
