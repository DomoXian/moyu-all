package com.moyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MoyuCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoyuCoreApplication.class, args);
	}
}
