package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.*;
import com.revature.models.Order;
import com.revature.models.OrderItem;
import com.revature.models.OrderStatus;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	private OrderDAO oDAO;
	private OrderItemDAO oiDAO;
	private UserDAO uDAO;
	private OrderStatusDAO osDAO;
	private FoodItemDAO fDAO;
	
	@Autowired
	public OrderController(OrderDAO oDAO, OrderItemDAO oiDAO, FoodItemDAO fDAO, UserDAO uDAO, OrderStatusDAO osDAO) {
		super();
		this.oDAO = oDAO;
		this.oiDAO = oiDAO;
		this.fDAO = fDAO;
		this.uDAO = uDAO;
		this.osDAO = osDAO;
	}
	
	// Getting all Orders
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {
		return ResponseEntity.ok(oDAO.findAll());
	}
	
	// Getting Order by ID
	@GetMapping(value="/{orderId}")
	public ResponseEntity<Order> findOrderById(@PathVariable int orderId) {
		Optional<Order> orderOptional = oDAO.findById(orderId);
		
		if (orderOptional.isPresent()) {
			Order order = orderOptional.get();
			return ResponseEntity.ok(order);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	// Getting Order by Restaurant ID
	@GetMapping(value="/for-restaurant/{resId}")
	public ResponseEntity<List<Order>> findOrdersByRestaurantId(@PathVariable int resId) {
		Optional<List<Order>> ordersOptional = oDAO.findByRestaurantIdFk(resId);
		
		if (ordersOptional.isPresent()) {
			List<Order> orders = ordersOptional.get();
			return ResponseEntity.ok(orders);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	// Adding new order
	@PostMapping(value="/{uId}/{osId}")
	public ResponseEntity<Order> sendOrder(@RequestBody Order o, @PathVariable int uId, @PathVariable int osId) {
		List<OrderItem> oiList = o.getOrderItems();
		for (int i = 0; i < oiList.size(); i++) {
			oiList.get(i).setFoodItemId(fDAO.findById(oiList.get(i).getFoodItemId().getFoodItemId()).get());
			//oiList.get(i).setOrderId(o);
		}
		o.setUserId(uDAO.findById(uId).get());
		o.setOrderStatusId(osDAO.findById(osId).get());
		Order order = oDAO.save(o);
		if (order == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			return ResponseEntity.accepted().body(order);
		}
	}
	
	@GetMapping(value="/order")
	public ResponseEntity<Order> getOrder(@RequestBody int orderId) {
		Order o = oDAO.findById(orderId).get();
		if (o == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			List<OrderItem> oiList = new ArrayList<>();
			for (int i = 0; i < o.getOrderItems().size(); i++) {
				oiList.set(i, oiDAO.findById(o.getOrderItems().get(i).getOrderItemId()).get());
			}
			o.setOrderItems(oiList);
			return ResponseEntity.accepted().body(o);
		}
	}
	
	// Changing order status
	@PutMapping(value="/update")
	public ResponseEntity<Order> updateVehicle(@RequestBody Order passedOrder) {
		
		Optional<Order> orderToBeUpdatedOptional = oDAO.findById(passedOrder.getOrderId());
		
		if (orderToBeUpdatedOptional.isPresent()) {
			
			Order updatedOrder = oDAO.save(passedOrder);
			
			if(updatedOrder != null) {
				return ResponseEntity.accepted().body(updatedOrder);
			}
		}
		
		return ResponseEntity.badRequest().build(); 		
	}
	
	// Adding new Order - RETIRED, probably won't need it
//	@PostMapping(value = "/{userId}")
//	public ResponseEntity<Order> registerUser(@RequestBody Order passedOrder, @PathVariable int userId) {
//		
//		// Trying to get user role with path variable and order status of 'Placed'
//		Optional<User> userOptional = uDAO.findById(userId);
//		Optional<OrderStatus> orderStatusOptional = osDAO.findById(1);
//
//		if(userOptional.isPresent() && orderStatusOptional.isPresent()) {
//		
//			// Getting user and adding it to the passed user object 
//			User user = userOptional.get();
//			passedOrder.setUserId(user);
//			
//			// Setting status to placed
//			OrderStatus orderStatus = orderStatusOptional.get();
//			passedOrder.setOrderStatusId(orderStatus);
//			
//			// Saving the new user to DB
//			Order newOrder = oDAO.save(passedOrder);
//			
//			if(newOrder != null) {
//				return ResponseEntity.accepted().body(newOrder);
//				}
//			}
//		
//		return ResponseEntity.badRequest().build();
//		
//		// how do we limit this information to not show password? and then what
//		
//	}
	
}