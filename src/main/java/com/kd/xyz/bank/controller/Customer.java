package com.kd.xyz.bank.controller;

import com.kd.xyz.bank.dto.UserDto;
import com.kd.xyz.bank.entity.User;
import com.kd.xyz.bank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class Customer {

    @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveCustomer(@RequestBody User user){
        UserDto customer = customerService.saveUser(user);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAll() {
        List<UserDto> users = customerService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> getHello() {
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }

}
