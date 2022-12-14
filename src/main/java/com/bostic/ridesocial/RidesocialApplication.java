package com.bostic.ridesocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class RidesocialApplication{
	public static void main(String[] args) {
		SpringApplication.run(RidesocialApplication.class, args);
	}

}
