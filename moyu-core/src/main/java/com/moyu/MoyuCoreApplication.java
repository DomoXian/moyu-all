package com.moyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
public class MoyuCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoyuCoreApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	@GetMapping("/bye")
	public String bye(){
		return"good bye";
	}

}
