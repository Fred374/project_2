package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "order_items")
@Component
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderItemId;
	
	@Column
	private int orderItemFoodId;
	
	@Column
	private int orderItemNum;
	
	@Column
	private double orderItemTotalCost;
	
	@Column
	private int orderIdFk;

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderItem(int orderItemId, int orderItemFoodId, int orderItemNum, double orderItemTotalCost, int orderIdFk) {
		super();
		this.orderItemId = orderItemId;
		this.orderItemFoodId = orderItemFoodId;
		this.orderItemNum = orderItemNum;
		this.orderItemTotalCost = orderItemTotalCost;
		this.orderIdFk = orderIdFk;
	}

	public OrderItem(int orderItemFoodId, int orderItemNum, double orderItemTotalCost, int orderIdFk) {
		super();
		this.orderItemFoodId = orderItemFoodId;
		this.orderItemNum = orderItemNum;
		this.orderItemTotalCost = orderItemTotalCost;
		this.orderIdFk = orderIdFk;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderItemFoodId=" + orderItemFoodId + ", orderItemNum="
				+ orderItemNum + ", orderItemTotalCost=" + orderItemTotalCost + ", orderIdFk=" + orderIdFk + "]";
	}

	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderItemFoodId() {
		return orderItemFoodId;
	}

	public void setOrderItemFoodId(int orderItemFoodId) {
		this.orderItemFoodId = orderItemFoodId;
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

	public int getOrderIdFk() {
		return orderIdFk;
	}

	public void setOrderIdFk(int orderIdFk) {
		this.orderIdFk = orderIdFk;
	}

}
