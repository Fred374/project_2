package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Order;

@RestController
@RequestMapping(value="/restaurant")
public class RestaurantController {

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
	
}

