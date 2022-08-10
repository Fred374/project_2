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
	// All we need to learn is how to route the users input to here... simple enough to start
	// public ResponseEntity registerUser(@RequestBody Users u) {
	public ResponseEntity<User> registerUser(@RequestBody User passedUser, @PathVariable int roleId) {

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

		// or here?
		
		// Trying to get user role with path variable
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
	
	//Method to take in User login credentials
	@PostMapping(value = "/login") 
	public ResponseEntity<User> login(@RequestBody User u){
		
		//calling the findByUserUsernameAndUserPassword method, using the given User's values
		Optional<User> optionalUser = uDAO.findByUserUsernameAndUserPassword(u.getUserUsername(), u.getUserPassword());
		
		//empty user to get filled with the optional
		User user;
		
		if(optionalUser.isPresent()) { //if login is successful...
			user = optionalUser.get(); //making a user object from the optional
			return ResponseEntity.accepted().body(user); //sending the user back into the response
		
	}
	//if login failed...
	return ResponseEntity.status(403).build();// send a forbidden status code
	
}
	
	
	 
}