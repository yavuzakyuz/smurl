package com.example.demo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlController {

    @CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/greeting")
	public Url getUrlfromClient(@RequestParam(required = false, defaultValue = "World") String name) {
		return new Url();
	}
    
}


