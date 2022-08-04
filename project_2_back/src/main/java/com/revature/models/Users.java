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
@Table(name = "users")
@Component
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // makes id serial
	private int userId;
	
	@Column
	private String userUsername;
	
	@Column
	private String userPassword;
	
	@Column
	private String userFirstName;
	
	@Column
	private String userLastName;
	
	@Column
	private String userEmail;
	
	// noticed I might've done something extra below
	
	// @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "roleId") // or role_id
	// private Roles userRoleFk;
	
	@Column
	private int userRoleFk;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	//all args
	public Users(int userId, String userUsername, String userPassword, String userFirstName, String userLastName,
			String userEmail, int userRoleFk) {
		super();
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleFk = userRoleFk;
	}

	// all except id for creating users
	public Users(String userUsername, String userPassword, String userFirstName, String userLastName, String userEmail,
			int userRoleFk) {
		super();
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleFk = userRoleFk;
	}

	// all except id and password (for accessing user object post login)
	public Users(String userUsername, String userFirstName, String userLastName, String userEmail, int userRoleFk) {
		super();
		this.userUsername = userUsername;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleFk = userRoleFk;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserRoleFk() {
		return userRoleFk;
	}

	public void setUserRoleFk(int userRoleFk) {
		this.userRoleFk = userRoleFk;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleFk=" + userRoleFk + "]";
	}	
	
}
