package com.revature.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Restaurant;

@Repository
public interface RestaurantDAO extends JpaRepository<Restaurant,Integer> {

}
