package com.winnertech.point_click;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PointClickApplication {

	public static void main(String[] args) {
		SpringApplication.run(PointClickApplication.class, args);
	}
	
	  @Bean 
	  public BCryptPasswordEncoder getBCPE() 
	  { 
		  return new BCryptPasswordEncoder();
	  }	

}
