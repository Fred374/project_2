package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.FoodItem;

@Repository
public interface FoodItemDAO extends JpaRepository<FoodItem,Integer> {

}
