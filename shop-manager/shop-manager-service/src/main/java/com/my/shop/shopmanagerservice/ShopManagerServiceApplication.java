package com.my.shop.shopmanagerservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.shop.mapper")
public class ShopManagerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopManagerServiceApplication.class, args);
	}
}
