package com.revature;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controllers.UserController;
import com.revature.daos.UserDAO;
import com.revature.models.User;

@RunWith(SpringRunner.class)
@SpringBootTest
class Project2BackApplicationTests {

	@Autowired
	@MockBean
	private UserController userController;
	
	@MockBean
	private UserDAO userDAO;
	
	
	
	@Test
	public void getUsersTest() {

		ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
				
		when(userController.getAllUsers()).thenReturn(r);
	
		assertEquals(HttpStatus.ACCEPTED, userController.getAllUsers().getStatusCode());
	}

//	new User("user1", "pass1", "first", "last", "user1@email.com"), new User("user2", "pass2", "first", "last", "user2@email.com"), new User("user3", "pass3", "first", "last", "user3@email.com"))
//	this.userId = userId;
//	this.userUsername = userUsername;
//	this.userPassword = userPassword;
//	this.userFirstName = userFirstName;
//	this.userLastName = userLastName;
//	this.userEmail = userEmail;
}
