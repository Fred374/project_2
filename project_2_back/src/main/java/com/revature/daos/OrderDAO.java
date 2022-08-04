package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.models.Order;

@Repository
public interface OrderDAO extends JpaRepository<Order,Integer> {

}
