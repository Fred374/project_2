package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.OrderItem;

@Repository
public interface OrderItemDAO extends JpaRepository<OrderItem,Integer> {

}
