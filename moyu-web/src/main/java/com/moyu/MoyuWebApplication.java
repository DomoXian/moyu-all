package com.moyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MoyuWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoyuWebApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}
}
