package com.shubham.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shubh")
public class EmployeeController {

    @GetMapping("/getName/{id}")
    public String getNameById(@PathVariable int id) {
        return "Hi My Name is Shubham, I'm software Developer";
    }
}
