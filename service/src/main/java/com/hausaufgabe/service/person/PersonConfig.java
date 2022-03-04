package com.hausaufgabe.service.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class PersonConfig {

    @Bean
    CommandLineRunner commandLineRunner(PersonDB personDB) {
        return args -> {
            Person demo = new Person(
                    "alexander",
                    LocalDate.of(1999, Month.JANUARY, 1)
            );
            personDB.save(demo);
        };
    }
}
