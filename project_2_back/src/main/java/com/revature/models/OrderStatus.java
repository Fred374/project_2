package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="order_statuses")
@Component
public class OrderStatus {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderStatusId;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true)
	private String orderStatusName;

	
	/* Constructors ---------------------------------------------------------------------------------------- */
	public OrderStatus() {
		super();
	}
	
	public OrderStatus(String orderStatusName) {
		super();
		this.orderStatusName = orderStatusName;
	}

	public OrderStatus(int orderStatusId, String orderStatusName) {
		super();
		this.orderStatusId = orderStatusId;
		this.orderStatusName = orderStatusName;
	}

	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "OrderStatus [orderStatusId=" + orderStatusId + ", orderStatusName=" + orderStatusName + "]";
	}
	
	/* Getters & Setters ----------------------------------------------------------------------------------- */
	public int getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatusName() {
		return orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

}
