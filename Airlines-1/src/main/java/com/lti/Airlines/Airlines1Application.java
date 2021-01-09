package com.lti.Airlines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.lti"})
@EntityScan(basePackages = "com.lti")
public class Airlines1Application {

	public static void main(String[] args) {
		SpringApplication.run(Airlines1Application.class, args);
	}

}
