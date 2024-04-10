package com.kd.xyz.bank.service;

import com.kd.xyz.bank.entity.User;

import java.util.List;

public interface CustomerService {

    public List<User> getAllUsers();

    public User findUserById(Long id);

    public User saveUser(User user);
}
