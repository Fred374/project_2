package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.OrderStatus;

@Repository
public interface OrderStatusDAO extends JpaRepository<OrderStatus,Integer> {

}
