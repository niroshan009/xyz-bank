package com.kd.xyz.bank.service;

import com.kd.xyz.bank.dto.UserDto;
import com.kd.xyz.bank.entity.User;

import java.util.List;

public interface CustomerService {

    public List<UserDto> getAllUsers();

    public UserDto findUserById(Long id);

    public UserDto saveUser(User user);
}
