package com.example.bookservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.bookservice")
@EnableJpaRepositories(basePackages = "com.example.bookservice")
@EntityScan(basePackages = "com.example.bookservice")
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner init(BookRepository repo) {
        return args -> {
            System.out.println(" STARTING INIT");

            if (repo == null) {
                System.out.println("❌ BookRepository is NULL!");
                return;
            }

            try {
                System.out.println(" Inserting books...");
                repo.save(new Book("Kubernetes in Action"));
                repo.save(new Book("Spring Boot 3 Guide"));
                System.out.println("Books inserted.");
            } catch (Exception e) {
                System.err.println(" ERROR inserting books: " + e.getMessage());
                e.printStackTrace();
            }
        };
    }
}

