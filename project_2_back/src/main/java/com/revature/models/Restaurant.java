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
public class Restaurant {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int restaurantId;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String restaurantName;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String restaurantUsername;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String restaurantPassword;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String restaurantEmail;

	/* Constructors ---------------------------------------------------------------------------------------- */
	public Restaurant() {
		super();
	}

	//all-args
	public Restaurant(int restaurantId, String restaurantName, String restaurantUsername, String restaurantPassword,
			String restaurantEmail) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantUsername = restaurantUsername;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
	}

	// all except id (in-case of creating a new Restaurant)
	public Restaurant(String restaurantName, String restaurantUsername, String restaurantPassword,
			String restaurantEmail) {
		super();
		this.restaurantName = restaurantName;
		this.restaurantUsername = restaurantUsername;
		this.restaurantPassword = restaurantPassword;
		this.restaurantEmail = restaurantEmail;
	}
	
	// all except password (for accessing restaurant data later)
	public Restaurant(int restaurantId, String restaurantName, String restaurantUsername, String restaurantEmail) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.restaurantUsername = restaurantUsername;
		this.restaurantEmail = restaurantEmail;
	}
	
	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "Restaurants [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
				+ ", restaurantUsername=" + restaurantUsername + ", restaurantPassword=" + restaurantPassword
				+ ", restaurantEmail=" + restaurantEmail + "]";
	}



	/* Getters & Setters ----------------------------------------------------------------------------------- */
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

}
