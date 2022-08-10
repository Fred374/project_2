package com.revature.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	// Referencing columns of other tables
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "userId")
	private User userId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "orderStatusId")
	private OrderStatus orderStatusId;
	
	private int restaurantIdFk; // Goes to external API
	
	// Other tables referencing orders
	@OneToMany(targetEntity=OrderItem.class, cascade=CascadeType.ALL)
	private List<OrderItem> orderItems;
	
	/* Constructors ---------------------------------------------------------------------------------------- */
	public Order() {
		super();
	}

	public Order(double orderCost, User userId, int restaurantIdFk, OrderStatus orderStatusId,
			List<OrderItem> orderItems) {
		super();
		this.orderCost = orderCost;
		this.userId = userId;
		this.restaurantIdFk = restaurantIdFk;
		this.orderStatusId = orderStatusId;
		this.orderItems = orderItems;
	}

	public Order(int orderId, double orderCost, User userId, int restaurantIdFk, OrderStatus orderStatusId,
			List<OrderItem> orderItems) {
		super();
		this.orderId = orderId;
		this.orderCost = orderCost;
		this.userId = userId;
		this.restaurantIdFk = restaurantIdFk;
		this.orderStatusId = orderStatusId;
		this.orderItems = orderItems;
	}

	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderCost=" + orderCost + ", userId=" + userId + ", restaurantIdFk="
				+ restaurantIdFk + ", orderStatusId=" + orderStatusId + ", orderItems=" + orderItems + "]";
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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public int getRestaurantIdFk() {
		return restaurantIdFk;
	}

	public void setRestaurantIdFk(int restaurantIdFk) {
		this.restaurantIdFk = restaurantIdFk;
	}

	public OrderStatus getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(OrderStatus orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}	

}
