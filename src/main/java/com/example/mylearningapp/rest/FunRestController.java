package com.example.mylearningapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose "/" to simply return hello world
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }

    // expose a new endpoint
    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Run a hard 5k!";
    }
}
