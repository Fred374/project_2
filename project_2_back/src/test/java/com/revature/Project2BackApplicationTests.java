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

import com.revature.controllers.FoodItemController;
import com.revature.controllers.OrderController;
import com.revature.controllers.UserController;
import com.revature.daos.UserDAO;
import com.revature.daos.UserRoleDAO;
import com.revature.models.Order;
import com.revature.models.OrderStatus;
import com.revature.models.User;
import com.revature.models.UserRole;

@RunWith(SpringRunner.class)
@SpringBootTest
class Project2BackApplicationTests {

	@Autowired
	@MockBean
	static private UserController userController;
	
	@Autowired
	@MockBean
	static private OrderController orderController;
	

	@Autowired
	@MockBean
	static private FoodItemController foodItemController;
	
	
	
	@MockBean
	static private UserDAO userDAO;
	
	@MockBean
	static private UserRoleDAO userRoleDAO;
	
	@BeforeAll
	static public void setup() {
//		userController = Mockito.spy(new UserController(userDAO, userRoleDAO));
	}
	
	
	@Test
	void contextLoads() {
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
	

	
	@Test
	public void getOrdersTest() {

		ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
				
		when(orderController.getAllOrders()).thenReturn(r);
	
		assertEquals(HttpStatus.ACCEPTED, orderController.getAllOrders().getStatusCode());
	}
	
	@Test
	public void getfoodItemsTest() {

		ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
				
		when(foodItemController.getAllFoodItems()).thenReturn(r);
	
		assertEquals(HttpStatus.ACCEPTED, foodItemController.getAllFoodItems().getStatusCode());
	}
	
//	@Test
//	public void sendOrderTest() {
//Order o = new Order ();
//int uId = o.getUserId();
//int osId = o.getOrderStatusId()
//		ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
//				
//		when(orderController.sendOrder(o, uId, osId)).thenReturn(r);
//	
//		assertEquals(HttpStatus.ACCEPTED, orderController.sendOrder(o, uId, osId).getStatusCode());
//		
//	}
	
	@Test
	public void loginTest() {
User u = new User();

		ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
				
		when(userController.login(u)).thenReturn(r);
	
		assertEquals(HttpStatus.ACCEPTED, userController.login(u).getStatusCode());
	}
	
	
//	@Test
//	public void registrationTest() {
//User passedUser = new User();
//UserRole roleId = passedUser.getUserRoleId();
//		ResponseEntity r = new ResponseEntity(HttpStatus.ACCEPTED);
//				
//		when(userController.registerUser(passedUser, roleId)).thenReturn(r);
//	
//		assertEquals(HttpStatus.ACCEPTED, userController.registerUser(passedUser, roleId).getStatusCode());
//	}
}
