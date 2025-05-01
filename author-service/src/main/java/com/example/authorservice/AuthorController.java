package com.example.authorservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {
    @GetMapping("/author")
    public String author() {
        return "Hello from Author Service!";
    }
}

