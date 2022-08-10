package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.UserRole;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Integer> {

}
