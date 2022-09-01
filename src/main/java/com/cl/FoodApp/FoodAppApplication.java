package com.cl.FoodApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
(scanBasePackages={
		"com.cl.FoodApp", "com.cl.FoodApp.service.FoodOrderService"})


public class FoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppApplication.class, args);
	}

}
