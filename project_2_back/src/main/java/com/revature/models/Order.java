package com.revature.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "orders")
@Component
public class Order {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(nullable = false)
	private double orderCost;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User userId;
	
	private int restaurantIdFk;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "order_status_id_fk", referencedColumnName="orderStatusId")
	private OrderStatus orderStatusIdFk;
	
	@OneToMany(mappedBy="orderIdFk", cascade=CascadeType.ALL)
	private List<OrderItem> orderItems;

	
	/* Constructors ---------------------------------------------------------------------------------------- */
	public Order() {
		super();
	}

	public Order(double orderCost, User userIdFk, int restaurantIdFk, OrderStatus orderStatusIdFk,
			List<OrderItem> orderItems) {
		super();
		this.orderCost = orderCost;
		this.userIdFk = userIdFk;
		this.restaurantIdFk = restaurantIdFk;
		this.orderStatusIdFk = orderStatusIdFk;
		this.orderItems = orderItems;
	}

	public Order(int orderId, double orderCost, User userIdFk, int restaurantIdFk, OrderStatus orderStatusIdFk,
			List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderCost = orderCost;
		this.userIdFk = userIdFk;
		this.restaurantIdFk = restaurantIdFk;
		this.orderStatusIdFk = orderStatusIdFk;
		this.orderItems = orderItems;
	}

	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCost=" + orderCost + ", userIdFk=" + userIdFk + ", restaurantIdFk="
				+ restaurantIdFk + ", orderStatusIdFk=" + orderStatusIdFk + ", orderItems=" + orderItems + "]";
	}

	/* Getters & Setters ----------------------------------------------------------------------------------- */
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

	public User getUserIdFk() {
		return userIdFk;
	}

	public void setUserIdFk(User userIdFk) {
		this.userIdFk = userIdFk;
	}

	public int getRestaurantIdFk() {
		return restaurantIdFk;
	}

	public void setRestaurantIdFk(int restaurantIdFk) {
		this.restaurantIdFk = restaurantIdFk;
	}

	public OrderStatus getOrderStatusIdFk() {
		return orderStatusIdFk;
	}

	public void setOrderStatusIdFk(OrderStatus orderStatusIdFk) {
		this.orderStatusIdFk = orderStatusIdFk;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}	

}
