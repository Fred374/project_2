package com.revature.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "roles")
@Component
public class UserRole {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String roleName;

	/* Constructors ---------------------------------------------------------------------------------------- */
	public UserRole() {
		super();
	}

	public UserRole(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	// do we need it? maybe not but...
	// what if there was a user subscription for discounts
	public UserRole(String roleName) {
		super();
		this.roleName = roleName;
	}
	
	/* toString -------------------------------------------------------------------------------------------- */
	@Override
	public String toString() {
		return "UserRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	/* Getters & Setters ----------------------------------------------------------------------------------- */
	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	
}
