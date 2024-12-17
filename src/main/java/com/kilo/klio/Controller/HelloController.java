package com.kilo.klio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hellotwo")
    public String sayHello() {
        return "Hello, Spring Boot from Klio in controller!";
    }
}
