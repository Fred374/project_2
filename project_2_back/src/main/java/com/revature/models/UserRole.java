package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "user_roles")
@Component
public class UserRole {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userRoleId;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String userRoleName;

	/* Constructors ---------------------------------------------------------------------------------------- */
	public UserRole() {
		super();
	}

	public UserRole(int userRoleId, String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}

	// do we need it? maybe not but...
	// what if there was a user subscription for discounts
	public UserRole(String userRoleName) {
		super();
		this.userRoleName = userRoleName;
	}
	
	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + "]";
	}
	
	/* Getters & Setters ----------------------------------------------------------------------------------- */
	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	
	
}
