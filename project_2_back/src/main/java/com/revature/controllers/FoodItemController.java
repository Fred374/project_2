package com.revature.controllers;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.revature.daos.FoodItemDAO;
import com.revature.models.FoodItem;

@RestController
@CrossOrigin
@RequestMapping(value="/food_item")
@ResponseBody
public class FoodItemController {

	private FoodItemDAO fDAO;
	
	public FoodItemController(FoodItemDAO fDAO) {
		super();
		this.fDAO = fDAO;
	}
	
	@GetMapping(value="/{resId}")
	public ResponseEntity<List<FoodItem>> getFood(@PathVariable int resId) {
		return ResponseEntity.ok(fDAO.findByRestaurantIdFk(resId).get());
	}
}
