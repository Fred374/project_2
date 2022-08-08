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

import com.revature.daos.FoodItemDAO;
import com.revature.daos.OrderDAO;
import com.revature.daos.OrderItemDAO;
import com.revature.models.FoodItem;
import com.revature.models.Order;
import com.revature.models.OrderItem;
import com.revature.models.OrderStatus;

@RestController
@RequestMapping(value="/order-item")
public class OrderItemController {

	private OrderItemDAO oiDAO;
	private OrderDAO oDAO;
	private FoodItemDAO fiDAO;

	@Autowired
	public OrderItemController(OrderItemDAO oiDAO, OrderDAO oDAO, FoodItemDAO fiDAO) {
		super();
		this.oiDAO = oiDAO;
		this.oDAO = oDAO;
		this.fiDAO = fiDAO;
	}
	
	// Getting all OrderItems
	@GetMapping
	public ResponseEntity<List<OrderItem>> getAllOrderItems() {
		return ResponseEntity.ok(oiDAO.findAll());
	}
	
	// Getting OrderItems for order by orderId
	@GetMapping(value="/{orderId}")
	public ResponseEntity<List<OrderItem>> getOrderItemsByOrderId(@PathVariable int orderId) {
		
		Optional<List<OrderItem>> orderItemsOptional = oiDAO.findByOrderId(orderId);
		
		if (orderItemsOptional.isPresent()) {
			List<OrderItem> orderItem = orderItemsOptional.get();
			return ResponseEntity.ok(orderItem);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	// Inserting FoodItem
		@PostMapping(value = "/{orderId}/{foodItemId}")
		public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem passedOrderItem, @PathVariable int orderId, @PathVariable int foodItemId) {
			
			Optional<Order> orderOptional = oDAO.findById(orderId);
			Optional<FoodItem> foodItemOptional = fiDAO.findById(foodItemId);
			
			if (orderOptional.isPresent() && foodItemOptional.isPresent()) {
				
				// Getting Order for orderItem and adding it to our new object
				Order order = orderOptional.get();
				passedOrderItem.setOrderId(order);
				
				// Getting FoodItem for orderItem and adding it to our new object
				FoodItem foodItem = foodItemOptional.get();
				passedOrderItem.setFoodItemId(foodItem);
				
				// Calculating total cost for OrderItem and adding it to our ne object
				double foodItemPrice = foodItem.getFoodItemCost();
				double foodItemNum = passedOrderItem.getOrderItemNum();
				double orderItemTotalCost = foodItemPrice * foodItemNum;
				passedOrderItem.setOrderItemTotalCost(orderItemTotalCost);
				
				// Saving new object to DB
				OrderItem newOrderItem = oiDAO.save(passedOrderItem);
				
				
				if(newOrderItem != null) {
					return ResponseEntity.accepted().body(newOrderItem);
				}
				
			}
						
			return ResponseEntity.badRequest().build();
		}
	
	
	
}
