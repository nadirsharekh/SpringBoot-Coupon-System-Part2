package com.devtech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import testing.Tests;

@SpringBootApplication
@Configuration
@EnableScheduling
@ComponentScan(basePackages="daily_job")
public class CouponSystemSpringBootApplication{
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(CouponSystemSpringBootApplication.class, args);
		
		Tests test=new Tests();
		test.run();
	}
}
