package com.kd.xyz.bank.controller;

import com.kd.xyz.bank.entity.User;
import com.kd.xyz.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class Customer {

    @Autowired
    CustomerService customerService;

    @GetMapping("/health-check")
    public String getStatus() {
        return "hello world";
    }


    @PostMapping("/save")
    public ResponseEntity<User> saveCustomer(@RequestBody User user){
        User customer = customerService.saveUser(user);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}
