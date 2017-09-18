package com.moyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@SpringBootApplication
@EnableScheduling
@RestController
@EnableRedisHttpSession
public class MoyuCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoyuCoreApplication.class, args);
	}

}
