package com.revature.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private int orderUserIdFk;
	
	@Column
	private int orderRestaurantIdFk;
	
	@Column
	private int orderStatus;
	
	@OneToMany(mappedBy="orderFk", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<OrderItem> orderItems;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int orderId, double orderCost, int orderUserIdFk, int orderRestaurantIdFk, int orderStatus,
			List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderCost = orderCost;
		this.orderUserIdFk = orderUserIdFk;
		this.orderRestaurantIdFk = orderRestaurantIdFk;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	public Order(double orderCost, int orderUserIdFk, int orderRestaurantIdFk, int orderStatus,
			List<OrderItem> orderItems) {
		super();
		this.orderCost = orderCost;
		this.orderUserIdFk = orderUserIdFk;
		this.orderRestaurantIdFk = orderRestaurantIdFk;
		this.orderStatus = orderStatus;
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCost=" + orderCost + ", orderUserIdFk=" + orderUserIdFk
				+ ", orderRestaurantIdFk=" + orderRestaurantIdFk + ", orderStatus=" + orderStatus + ", orderItems="
				+ orderItems + "]";
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

	public int getOrderUserIdFk() {
		return orderUserIdFk;
	}

	public void setOrderUserIdFk(int orderUserIdFk) {
		this.orderUserIdFk = orderUserIdFk;
	}

	public int getOrderRestaurantIdFk() {
		return orderRestaurantIdFk;
	}

	public void setOrderRestaurantIdFk(int orderRestaurantIdFk) {
		this.orderRestaurantIdFk = orderRestaurantIdFk;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
