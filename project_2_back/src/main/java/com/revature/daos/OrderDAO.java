package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {
	
	public Optional<List<Order>> findByRestaurantIdFkOrderByOrderIdDesc(int resId);

}
