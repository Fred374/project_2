package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "order_items")
@Component
public class OrderItem {
	
	/* Defining fields/DB Columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
		
	@Column
	private int orderItemNum;
	
	@Column
	private double orderItemTotalCost;
	
	// Referencing other tables
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "foodItemId")
	private FoodItem foodItemId;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "orderId")
	private Order orderId;


	/* Constructors ---------------------------------------------------------------------------------------- */
	public OrderItem() {
		super();
	}

	
	// For passing as JSON body from fornt-end
	// orderId and foodItemId are passed via path variables, orderItemTotalCost is calculated in Controller
	public OrderItem(int orderItemNum) {
		super();
		this.orderItemNum = orderItemNum;
	}

	// For getting OrderItem
	public OrderItem(int orderItemId, int orderItemNum, double orderItemTotalCost) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemNum = orderItemNum;
		this.orderItemTotalCost = orderItemTotalCost;
	}


	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemNum=" + orderItemNum + ", orderItemTotalCost="
				+ orderItemTotalCost + ", foodItemId=" + foodItemId + ", orderId=" + orderId + "]";
	}

	/* Getters & Setters ----------------------------------------------------------------------------------- */
	public int getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}


	public int getOrderItemNum() {
		return orderItemNum;
	}


	public void setOrderItemNum(int orderItemNum) {
		this.orderItemNum = orderItemNum;
	}


	public double getOrderItemTotalCost() {
		return orderItemTotalCost;
	}


	public void setOrderItemTotalCost(double orderItemTotalCost) {
		this.orderItemTotalCost = orderItemTotalCost;
	}


	public FoodItem getFoodItemId() {
		return foodItemId;
	}


	public void setFoodItemId(FoodItem foodItemId) {
		this.foodItemId = foodItemId;
	}


	public Order getOrderId() {
		return orderId;
	}


	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}
	
}
