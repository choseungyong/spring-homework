package com.domain.app.controller;

import com.domain.app.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/com/domain/app")
    public Greeting hello(@RequestParam(value = "name", defaultValue = "world!") String name ) {
        var greeting = new Greeting(1L,name);
        return greeting;
    }
}
