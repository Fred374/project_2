package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.OrderDAO;
import com.revature.models.Order;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	private OrderDAO oDAO;
	
	public OrderController(OrderDAO oDAO) {
		super();
		this.oDAO = oDAO;
	}
	
	@PostMapping
	public ResponseEntity<Order> sendOrder(@RequestBody Order o) {
		Order order = oDAO.save(o);
		if (order == null) {
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.accepted().body(order);
	}

}
