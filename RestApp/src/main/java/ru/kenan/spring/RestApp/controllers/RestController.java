package ru.kenan.spring.RestApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello world";
    }
}
