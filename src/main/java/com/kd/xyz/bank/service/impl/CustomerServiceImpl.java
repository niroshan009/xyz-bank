package com.kd.xyz.bank.service.impl;

import com.kd.xyz.bank.dto.UserDto;
import com.kd.xyz.bank.entity.User;
import com.kd.xyz.bank.repository.UserRepository;
import com.kd.xyz.bank.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;



    @Override
    public List<UserDto> getAllUsers() {

        List<UserDto> users = new ArrayList<>();
        List usersFromDb = userRepository.findAll();

        users = Arrays.asList(modelMapper.map(usersFromDb, UserDto[].class));

        return users;
    }

    @Override
    public UserDto findUserById(Long id) {
        return null;
//        return userRepository.findById(id).get();
    }

    @Override
    public UserDto saveUser(User user) {
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }
}
