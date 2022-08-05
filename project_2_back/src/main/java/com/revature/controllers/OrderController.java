package com.revature.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.*;
import com.revature.models.Order;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	private OrderDAO oDAO;
	private OrderItemDAO oiDAO;
	
	public OrderController(OrderDAO oDAO, OrderItemDAO oiDAO) {
		super();
		this.oDAO = oDAO;
		this.oiDAO = oiDAO;
	}
	
	@PostMapping
	public ResponseEntity<Order> sendOrder(@RequestBody Order o) {
		Order order = oDAO.save(o);
		if (order == null) {
			for (int i = 0; i < o.getOrderItems().size(); i++) {
				oiDAO.save(o.getOrderItems().get(i));
			}
			return ResponseEntity.unprocessableEntity().build();
		}
		return ResponseEntity.accepted().body(order);
	}

}
