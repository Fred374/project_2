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
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "food_item_id_fk", referencedColumnName="foodItemId")
	private FoodItem orderItemFoodIdFk;

	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "order_id_fk", referencedColumnName="orderId")
	private Order orderIdFk;


	/* Constructors ---------------------------------------------------------------------------------------- */
	public OrderItem() {
		super();
	}


	public OrderItem(int orderItemNum, double orderItemTotalCost, FoodItem orderItemFoodIdFk, Order orderIdFk) {
		super();
		this.orderItemNum = orderItemNum;
		this.orderItemTotalCost = orderItemTotalCost;
		this.orderItemFoodIdFk = orderItemFoodIdFk;
		this.orderIdFk = orderIdFk;
	}


	public OrderItem(int orderItemId, int orderItemNum, double orderItemTotalCost, FoodItem orderItemFoodIdFk,
			Order orderIdFk) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemNum = orderItemNum;
		this.orderItemTotalCost = orderItemTotalCost;
		this.orderItemFoodIdFk = orderItemFoodIdFk;
		this.orderIdFk = orderIdFk;
	}

	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemNum=" + orderItemNum + ", orderItemTotalCost="
				+ orderItemTotalCost + ", orderItemFoodIdFk=" + orderItemFoodIdFk + ", orderIdFk=" + orderIdFk + "]";
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


	public FoodItem getOrderItemFoodIdFk() {
		return orderItemFoodIdFk;
	}


	public void setOrderItemFoodIdFk(FoodItem orderItemFoodIdFk) {
		this.orderItemFoodIdFk = orderItemFoodIdFk;
	}


	public Order getOrderIdFk() {
		return orderIdFk;
	}


	public void setOrderIdFk(Order orderIdFk) {
		this.orderIdFk = orderIdFk;
	}
	
}
