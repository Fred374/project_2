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
import com.revature.daos.*;
import com.revature.models.Order;
import com.revature.models.OrderStatus;
import com.revature.models.User;
import com.revature.models.UserRole;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	private OrderDAO oDAO;
	private OrderItemDAO oiDAO;
	private UserDAO uDAO;
	private OrderStatusDAO osDAO;
	
	@Autowired
	public OrderController(OrderDAO oDAO, OrderItemDAO oiDAO, UserDAO uDAO, OrderStatusDAO osDAO) {
		super();
		this.oDAO = oDAO;
		this.oiDAO = oiDAO;
		this.uDAO = uDAO;
		this.osDAO = osDAO;
	}
	
	// Getting all Orders
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return ResponseEntity.ok(oDAO.findAll());
	}
	
	// Getting Order by ID
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findOrderById(@PathVariable int id) {
		Optional<Order> orderOptional = oDAO.findById(id);
		
		if (orderOptional.isPresent()) {
			Order order = orderOptional.get();
			return ResponseEntity.ok(order);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	// Getting Order by Restaurant ID
	@GetMapping(value="/{id}")
	public ResponseEntity<List<Order>> findOrdersByRestaurantId(@PathVariable int resId) {
		Optional<List<Order>> ordersOptional = oDAO.findByRestaurantIdFk(resId);
		
		if (ordersOptional.isPresent()) {
			List<Order> orders = ordersOptional.get();
			return ResponseEntity.ok(orders);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	// Adding new Order
		@PostMapping(value = "/{userId}")
		public ResponseEntity<Order> registerUser(@RequestBody Order passedOrder, @PathVariable int userId) {
			
			// Trying to get user role with path variable and order status of 'Placed'
			Optional<User> userOptional = uDAO.findById(userId);
			Optional<OrderStatus> orderStatusOptional = osDAO.findById(1);

			if(userOptional.isPresent() && orderStatusOptional.isPresent()) {
				
				// Getting user and adding it to the passed user object 
				User user = userOptional.get();
				passedOrder.setUserId(user);
				
				// Setting status to placed
				OrderStatus orderStatus = orderStatusOptional.get();
				passedOrder.setOrderStatusId(orderStatus);
			
				// Saving the new user to DB
				Order newOrder = oDAO.save(passedOrder);
				
				if(newOrder != null) {
					return ResponseEntity.accepted().body(newOrder);
				}
			}
			
			return ResponseEntity.badRequest().build();
			
			// how do we limit this information to not show password? and then what 
		}
	
//	@PostMapping
//	public ResponseEntity<Order> sendOrder(@RequestBody Order o) {
//		Order order = oDAO.save(o);
//		if (order == null) {
//			for (int i = 0; i < o.getOrderItems().size(); i++) {
//				oiDAO.save(o.getOrderItems().get(i));
//			}
//			return ResponseEntity.unprocessableEntity().build();
//		}
//		return ResponseEntity.accepted().body(order);
//	}

}
