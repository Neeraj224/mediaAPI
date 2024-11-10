package dev.neeraj.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MoviesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	/*
	 * Well, even though this is a valid endpoint, we're not gonna
	 * make our APIs like this - we're actually gonna separate our design
	 * into different layers (wow, separation of concerns): service layer,
	 * data access layer, API layer, etc.
	 * */
	@GetMapping("/hello")
	public String apiHello() {
		return "Hello, Worlds!";
	}

}
