package com.example.cards.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CardsController {
    @GetMapping(value = "/sayHello")
    public String sayHello(){
        return "Say Hello from Cards2";
    }

    @PostMapping(value="/sayHello2")
    public List<String> sayHello2(){
        List<String> arr = new ArrayList<>();
        arr.add("1002");
        arr.add("2002");
        arr.add("3002");
        return arr;
    }
}
