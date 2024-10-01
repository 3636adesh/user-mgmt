package com.malunjkar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthServiceApplication.class, args);
	}

}


@RestController
class WelcomeController {

	@GetMapping
	public String hello() {
		return "<h1 style='color: blue; font-family: Arial, sans-serif; text-align: center;'>Welcome to Auth Service...!</h1>";
	}
}
