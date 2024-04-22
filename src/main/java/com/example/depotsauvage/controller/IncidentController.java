package com.example.depotsauvage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }
}