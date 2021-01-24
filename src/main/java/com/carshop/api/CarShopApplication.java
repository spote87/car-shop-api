package com.carshop.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class CarShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarShopApplication.class, args);
	}

  @Bean
  public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }

}
