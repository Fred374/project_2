package com.revature.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore // This makes it so that this field is ignored when returning Json in a response
	@OneToMany(mappedBy = "userRoleId") // mappedBy stops JPA from creating new UserRole when User is submitted
	private List<User> users;

	/* Constructors ---------------------------------------------------------------------------------------- */
	public UserRole() {
		super();
	}

	// Minus id and users, for adding new UserRole
	public UserRole(String userRoleName) {
		super();
		this.userRoleName = userRoleName;
	}
	
	// For getting UserRole
	public UserRole(int userRoleId, String userRoleName) {
		super();
		this.userRoleId = userRoleId;
		this.userRoleName = userRoleName;
	}

	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRoleName=" + userRoleName + ", users=" + users + "]";
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	// do we need it? maybe not but...
	// what if there was a user subscription for discounts
}