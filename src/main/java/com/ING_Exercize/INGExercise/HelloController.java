package com.ING_Exercize.INGExercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/getStart")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello from Spring Boot!";
    }


}