package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import redis.clients.jedis.Jedis;


@SpringBootApplication
@RestController
public class SmurlApiApplication {

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/")
	public String home() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("connected to jedi redis");
		jedis.set("somekey", "hello mom!");
		String value = jedis.get("somekey");
		return value;
	}
	
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/yavuz")
	public Url yavuzpage() {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println("connected to jedi redis");
		jedis.set("anotherkey", "hello me!");
		String stored = jedis.get("somekey");
		String value = jedis.get("anotherkey");
		value = value + stored;

		Url output_url = new Url(2, "yavuz", "here");
		return output_url;
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SmurlApiApplication.class, args);
	}

  
}
