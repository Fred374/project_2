package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.revature.controllers.OrderController;



@SpringBootApplication
public class Project2BackApplication {
//Port 4009
// Path: "/food"
	public static void main(String[] args) {
		SpringApplication.run(Project2BackApplication.class, args);
	}

}
