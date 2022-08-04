package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "restaurants")
@Component
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	
	@Column
	private String restaurantName;
	
	@Column
	private String restaurantUsername;
	
	@Column
	private String restaurantPassword;
	
	@Column
	private String restaurantEmail;

	
	public Restaurants() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all-args
	public Restaurants(int restaurantId, String restaurantName, String restaurantUsername, String restaurantPassword,
			String restaurantEmail) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantUsername = restaurantUsername;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
	} // 

	// all except id (in-case of creating a new Restaurant)
	public Restaurants(String restaurantName, String restaurantUsername, String restaurantPassword,
			String restaurantEmail) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantUsername = restaurantUsername;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
	}
	
	// all except id and password (for accessing restaurant data later)
	public Restaurants(String restaurantName, String restaurantUsername, String restaurantEmail) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantUsername = restaurantUsername;
		this.restaurantEmail = restaurantEmail;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getRestaurantUsername() {
		return restaurantUsername;
	}

	public void setRestaurantUsername(String restaurantUsername) {
		this.restaurantUsername = restaurantUsername;
	}

	public String getRestaurantPassword() {
		return restaurantPassword;
	}

	public void setRestaurantPassword(String restaurantPassword) {
		this.restaurantPassword = restaurantPassword;
	}

	public String getRestaurantEmail() {
		return restaurantEmail;
	}

	public void setRestaurantEmail(String restaurantEmail) {
		this.restaurantEmail = restaurantEmail;
	}

	@Override
	public String toString() {
		return "Restaurants [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantUsername=" + restaurantUsername + ", restaurantPassword=" + restaurantPassword
				+ ", restaurantEmail=" + restaurantEmail + "]";
	}

}
