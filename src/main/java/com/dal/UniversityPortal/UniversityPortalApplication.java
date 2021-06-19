package com.dal.UniversityPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UniversityPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniversityPortalApplication.class, args);
	}
	@GetMapping("/health_check")
	public String healthCheck() {
		return "OK";
	}

}
