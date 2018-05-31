package com.my.shop.shopmanagerweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class ShopManagerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopManagerWebApplication.class, args);
	}
}
