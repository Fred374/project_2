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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int FoodItemId;
	
	@Column
	private String FoodItemName;
	
	@Column
	private double FoodItemCost;
	
	@Column
	private int FoodItemRestaurantIdFk;

	public FoodItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodItem(int foodItemId, String foodItemName, double foodItemCost, int foodItemRestaurantIdFk) {
		super();
		FoodItemId = foodItemId;
		FoodItemName = foodItemName;
		FoodItemCost = foodItemCost;
		FoodItemRestaurantIdFk = foodItemRestaurantIdFk;
	}

	public FoodItem(String foodItemName, double foodItemCost, int foodItemRestaurantIdFk) {
		super();
		FoodItemName = foodItemName;
		FoodItemCost = foodItemCost;
		FoodItemRestaurantIdFk = foodItemRestaurantIdFk;
	}

	@Override
	public String toString() {
		return "FoodItem [FoodItemId=" + FoodItemId + ", FoodItemName=" + FoodItemName + ", FoodItemCost="
				+ FoodItemCost + ", FoodItemRestaurantIdFk=" + FoodItemRestaurantIdFk + "]";
	}

	public int getFoodItemId() {
		return FoodItemId;
	}

	public void setFoodItemId(int foodItemId) {
		FoodItemId = foodItemId;
	}

	public String getFoodItemName() {
		return FoodItemName;
	}

	public void setFoodItemName(String foodItemName) {
		FoodItemName = foodItemName;
	}

	public double getFoodItemCost() {
		return FoodItemCost;
	}

	public void setFoodItemCost(double foodItemCost) {
		FoodItemCost = foodItemCost;
	}

	public int getFoodItemRestaurantIdFk() {
		return FoodItemRestaurantIdFk;
	}

	public void setFoodItemRestaurantIdFk(int foodItemRestaurantIdFk) {
		FoodItemRestaurantIdFk = foodItemRestaurantIdFk;
	}

}
