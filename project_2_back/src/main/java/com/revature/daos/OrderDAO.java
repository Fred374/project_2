package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Order;
import com.revature.models.OrderItem;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {
	
	public Optional<List<Order>> findByRestaurantIdFk(int resId);

}
