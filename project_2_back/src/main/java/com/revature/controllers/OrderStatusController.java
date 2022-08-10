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

import com.revature.daos.OrderStatusDAO;
import com.revature.models.OrderStatus;

@RestController
@RequestMapping(value="/order-status")
public class OrderStatusController {
	
	private OrderStatusDAO osDAO;

	@Autowired
	public OrderStatusController(OrderStatusDAO osDAO) {
		super();
		this.osDAO = osDAO;
	}
	
	// Getting all OrderStatuses
	@GetMapping
	public ResponseEntity<List<OrderStatus>> getAllOrderStatuses() {
		return ResponseEntity.ok(osDAO.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<OrderStatus> findOrderStatusById(@PathVariable int id) {
		
		Optional<OrderStatus> orderStatusOptional = osDAO.findById(id);
		
		if (orderStatusOptional.isPresent()) {
			OrderStatus orderStatus = orderStatusOptional.get();
			return ResponseEntity.ok(orderStatus);
		}
		
		// If optional is not present then return no content status code and empty response body
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<OrderStatus> addOrderStatus(@RequestBody OrderStatus orderStatus) {
		
		OrderStatus newOrderStatus = osDAO.save(orderStatus);
		
		if (newOrderStatus != null) {
			return ResponseEntity.accepted().body(newOrderStatus);
		}
		
		return ResponseEntity.badRequest().build();
		
	}
}
