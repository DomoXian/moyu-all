package com.moyu;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
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

	@GetMapping("/hello")
	public String hello(){
		return "hello";
	}

	@GetMapping("/bye")
	public String bye(){
		return"good bye";
	}

	@GetMapping("/getSession")
	public Object getSession(HttpServletRequest request){
		String sessionId = request.getSession().getId();
		HashMap<String,Object> resultMap  = new HashMap<>();
		resultMap.put("sessionId",sessionId);
		return resultMap;
	}

}
