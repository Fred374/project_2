package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "orders")
@Component
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column
	private double orderCost;
	
	@Column
	private int orderUserId;
	
	@Column
	private int orderRestaurantId;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, double orderCost, int orderUserId, int orderRestaurantId) {
		super();
		this.orderId = orderId;
		this.orderCost = orderCost;
		this.orderUserId = orderUserId;
		this.orderRestaurantId = orderRestaurantId;
	}

	public Order(double orderCost, int orderUserId, int orderRestaurantId) {
		super();
		this.orderCost = orderCost;
		this.orderUserId = orderUserId;
		this.orderRestaurantId = orderRestaurantId;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCost=" + orderCost + ", orderUserId=" + orderUserId
				+ ", orderRestaurantId=" + orderRestaurantId + "]";
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderCost() {
		return orderCost;
	}

	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}

	public int getOrderUserId() {
		return orderUserId;
	}

	public void setOrderUserId(int orderUserId) {
		this.orderUserId = orderUserId;
	}

	public int getOrderRestaurantId() {
		return orderRestaurantId;
	}

	public void setOrderRestaurantId(int orderRestaurantId) {
		this.orderRestaurantId = orderRestaurantId;
	}

}
