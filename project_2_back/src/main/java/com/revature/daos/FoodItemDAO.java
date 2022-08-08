package com.revature.daos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.FoodItem;

@Repository
public interface FoodItemDAO extends JpaRepository<FoodItem,Integer> {

	public Optional<List<FoodItem>> findByRestaurantIdFk(int resId);
}
