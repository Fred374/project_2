package com.revature;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.controllers.OrderController;
import com.revature.controllers.UserController;
import com.revature.daos.UserDAO;
import com.revature.daos.UserRoleDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
class Project2BackApplicationTests {

	@Autowired
	@MockBean
	static private UserController userController;
	
	@Autowired
	@MockBean
	static private OrderController orderController;
	
	@MockBean
	static private UserDAO userDAO;
	
	@MockBean
	static private UserRoleDAO userRoleDAO;
	
	@BeforeAll
	static public void setup() {
//		userController = Mockito.spy(new UserController(userDAO, userRoleDAO));
	}
	
	
	@Test
	public void getUsersTest() {

		ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
				
		when(userController.getAllUsers()).thenReturn(r);
	
		assertEquals(HttpStatus.ACCEPTED, userController.getAllUsers().getStatusCode());
	}
	
//	@Test
//	public void getUserById() {
//		
//		Order mockOrder = Mockito.mock(Order.class);
//		
//		OngoingStubbing<Order> mockReturnedOrder = when(orderController.findOrderById(1).getBody()).thenReturn(mockOrder);
//		
//		assertNotNull(mockReturnedOrder);
//		
//	}
	
	
}
