package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name="food_items")
@Component
public class FoodItem {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int foodItemId;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"		
	)
	private String foodItemName;
	
	@Column(
			nullable = false		
	)
	private double foodItemCost;
	
	private int restaurantIdFk;

	/* Constructors ---------------------------------------------------------------------------------------- */
	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodItem(String foodItemName, double foodItemCost, int restaurantIdFk) {
		super();
		this.foodItemName = foodItemName;
		this.foodItemCost = foodItemCost;
		this.restaurantIdFk = restaurantIdFk;
	}

	public FoodItem(int foodItemId, String foodItemName, double foodItemCost, int restaurantIdFk) {
		super();
		this.foodItemId = foodItemId;
		this.foodItemName = foodItemName;
		this.foodItemCost = foodItemCost;
		this.restaurantIdFk = restaurantIdFk;
	}

	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "FoodItem [foodItemId=" + foodItemId + ", foodItemName=" + foodItemName + ", foodItemCost="
				+ foodItemCost + ", restaurantIdFk=" + restaurantIdFk + "]";
	}

	/* Getters & Setters ----------------------------------------------------------------------------------- */
	public int getFoodItemId() {
		return foodItemId;
	}


	public String getFoodItemName() {
		return foodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		this.foodItemName = foodItemName;
	}

	public double getFoodItemCost() {
		return foodItemCost;
	}

	public void setFoodItemCost(double foodItemCost) {
		this.foodItemCost = foodItemCost;
	}

	public int getRestaurantIdFk() {
		return restaurantIdFk;
	}

	public void setRestaurantIdFk(int restaurantIdFk) {
		this.restaurantIdFk = restaurantIdFk;
	}

	public void setFoodItemId(int foodItemId) {
		this.foodItemId = foodItemId;
	}

	
}
