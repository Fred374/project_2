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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "food_item_id")
	private FoodItem orderItemFoodIdFk;
	
	@Column
	private int orderItemNum;
	
	@Column
	private double orderItemTotalCost;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "order_id")
	private Order orderFk;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int orderItemId, FoodItem orderItemFoodIdFk, int orderItemNum, double orderItemTotalCost,
			Order orderFk) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemFoodIdFk = orderItemFoodIdFk;
		this.orderItemNum = orderItemNum;
		this.orderItemTotalCost = orderItemTotalCost;
		this.orderFk = orderFk;
	}

	public OrderItem(FoodItem orderItemFoodIdFk, int orderItemNum, double orderItemTotalCost, Order orderFk) {
		super();
		this.orderItemFoodIdFk = orderItemFoodIdFk;
		this.orderItemNum = orderItemNum;
		this.orderItemTotalCost = orderItemTotalCost;
		this.orderFk = orderFk;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemFoodIdFk=" + orderItemFoodIdFk + ", orderItemNum="
				+ orderItemNum + ", orderItemTotalCost=" + orderItemTotalCost + ", orderFk=" + orderFk + "]";
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public FoodItem getOrderItemFoodIdFk() {
		return orderItemFoodIdFk;
	}

	public void setOrderItemFoodIdFk(FoodItem orderItemFoodIdFk) {
		this.orderItemFoodIdFk = orderItemFoodIdFk;
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

	public Order getOrderFk() {
		return orderFk;
	}

	public void setOrderFk(Order orderFk) {
		this.orderFk = orderFk;
	}

}
