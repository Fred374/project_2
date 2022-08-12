package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.FoodItemDAO;
import com.revature.models.FoodItem;

@RestController
@RequestMapping(value="/food-item")
@ResponseBody
public class FoodItemController {

	private FoodItemDAO fDAO;
	
	@Autowired
	public FoodItemController(FoodItemDAO fDAO) {
		super();
		this.fDAO = fDAO;
	}
	
	// Getting all FoodItems
	@GetMapping
	public ResponseEntity<List<FoodItem>> getAllFoodItems() {
		return ResponseEntity.ok(fDAO.findAll());
	}
	
	// Getting FoodItem by Restaurant ID
	@GetMapping(value="/{resId}")
	public ResponseEntity<List<FoodItem>> getFood(@PathVariable Integer resId) {
		return ResponseEntity.ok(fDAO.findByRestaurantIdFk(resId).get());
	}
	
	// Inserting FoodItem
	@PostMapping
	public ResponseEntity<FoodItem> addFoodItem(@RequestBody FoodItem foodItem) {
		
		FoodItem newFoodItem = fDAO.save(foodItem);
		
		if (newFoodItem != null) {
			return ResponseEntity.accepted().body(newFoodItem);
		}
		
		return ResponseEntity.badRequest().build();
	}
}
