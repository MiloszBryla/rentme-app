package com.codecool.config;

import org.springframework.web.bind.annotation.*;


@RestController
public class JwtController {

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @PostMapping("/login")
    public void login(@RequestBody LoginCredentials credentials) {

    }

    @CrossOrigin
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}