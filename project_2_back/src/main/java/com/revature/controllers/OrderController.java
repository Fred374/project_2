package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.*;
import com.revature.models.Order;
import com.revature.models.OrderItem;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
	
	private OrderDAO oDAO;
	private OrderItemDAO oiDAO;
	private FoodItemDAO fDAO;
	
	public OrderController(OrderDAO oDAO, OrderItemDAO oiDAO, FoodItemDAO fDAO) {
		super();
		this.oDAO = oDAO;
		this.oiDAO = oiDAO;
		this.fDAO = fDAO;
	}
	
	@PostMapping(value="/{uId}/{osId}")
	public ResponseEntity<Order> sendOrder(@RequestBody Order o) {
		List<OrderItem> oiList = o.getOrderItems();
		for (int i = 0; i < oiList.size(); i++) {
			oiList.get(i).setFoodItemId(fDAO.findById(oiList.get(i).getFoodItemId().getFoodItemId()).get());
		}
		Order order = oDAO.save(o);
		if (order == null) {
			return ResponseEntity.unprocessableEntity().build();
		} else {
			return ResponseEntity.accepted().body(order);
		}
	}
	
	@GetMapping
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

}