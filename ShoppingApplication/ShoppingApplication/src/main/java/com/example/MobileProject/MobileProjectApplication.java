package com.example.MobileProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
@EntityScan("com")
@ComponentScan("com")
@SpringBootApplication
public class MobileProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileProjectApplication.class, args);
System.out.println("started");
	}

}
