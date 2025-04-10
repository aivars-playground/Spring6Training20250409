package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;

@RestController
public class HelloController {

    private Client repository;

    @Autowired
    public HelloController(Client repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String index() {

        repository.insert(new Person("aa"+Instant.now(),1));

        var soFar = repository.findAll();

        return Arrays.toString(soFar.toArray());
    }

}