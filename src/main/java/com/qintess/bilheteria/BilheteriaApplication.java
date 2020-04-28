package com.qintess.bilheteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EntityScan(basePackages = "com.qintess.bilheteria.model")
@ComponentScan(basePackages = {"com.qintess.*"})
@EnableJpaRepositories(basePackages = {"com.qintess.bilheteria.repository"})
@EnableTransactionManagement
public class BilheteriaApplication	{
	public static void main(String[] args) {
		SpringApplication.run(BilheteriaApplication.class, args);
	}
	
}
