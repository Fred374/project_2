package com.revature.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.OrderItem;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {

	public Optional<List<OrderItem>> findByOrderId(int orderId);
	
}
