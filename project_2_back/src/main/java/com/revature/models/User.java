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
public class User {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // makes id serial
	private int userId;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String userUsername;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String userPassword;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"			
	)
	private String userFirstName;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"			
	)
	private String userLastName;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String userEmail;
	
	// noticed I might've done something extra below
	
	// @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "roleId") // or role_id
	// private Roles userRoleIdFk;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name = "user_role_id_fk")
	private UserRole userRoleIdFk;

	/* Constructors ---------------------------------------------------------------------------------------- */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// all except id for creating users
	public User(String userUsername, String userPassword, String userFirstName, String userLastName, String userEmail,
			UserRole userRoleIdFk) {
		super();
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleIdFk = userRoleIdFk;
	}

	// all except id and password (for accessing user object post login)
	public User(int userId, String userUsername, String userFirstName, String userLastName, String userEmail,
			UserRole userRoleIdFk) {
		super();
		this.userId = userId;
		this.userUsername = userUsername;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleIdFk = userRoleIdFk;
	}

	//all args
	public User(int userId, String userUsername, String userPassword, String userFirstName, String userLastName,
			String userEmail, UserRole userRoleIdFk) {
		super();
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleIdFk = userRoleIdFk;
	}

	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRoleIdFk=" + userRoleIdFk + "]";
	}

	/* Getters & Setters ----------------------------------------------------------------------------------- */
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

	public UserRole getUserRoleIdFk() {
		return userRoleIdFk;
	}

	public void setUserRoleIdFk(UserRole userRoleIdFk) {
		this.userRoleIdFk = userRoleIdFk;
	}

}
