package com.ING_Exercize.INGExercise.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/HelloWorld")
public class HelloController {

    @GetMapping("/getStart")
    @Secured("ROLE_ADMIN")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping("/helloWorld")
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public String helloWorld() {
        return "Hello from Spring Boot!";
    }


}