package com.hausaufgabe.service;

import com.hausaufgabe.service.person.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class PersonenServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonenServiceApplication.class, args);
	}

}
