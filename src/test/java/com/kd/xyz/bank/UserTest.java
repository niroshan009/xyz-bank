package com.kd.xyz.bank;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.mockito.Mockito;

import java.util.List;
import java.util.ArrayList;

import com.kd.xyz.bank.dto.UserDto;
import com.kd.xyz.bank.entity.User;
import com.kd.xyz.bank.service.CustomerService;
import com.kd.xyz.bank.repository.UserRepository;
import com.kd.xyz.bank.service.impl.CustomerServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    private CustomerService customerService;

    @TestConfiguration
    static class UserServiceImplTestConfiguration {
        @Bean
        public CustomerService customerService() {
            return new CustomerServiceImpl();
        }
    }

    @BeforeAll
    public void setUp() {

        List<User> userList = new ArrayList<>();
        userList.add(new User(1L,"Thusitha", "Niroshan", "Savings"));
        Mockito.when(userRepository.findAll()).thenReturn(userList);
    }


    @Test
    public void test() {

        List users = customerService.getAllUsers();
        assertTrue(users.size() == 1,"Response size does not match");
        assertTrue( users.stream().allMatch(item -> item instanceof UserDto), "return class did not match");
        UserDto userDto = (UserDto) users.get(0);
        assertTrue(userDto.getFirstName().equals("Thusitha"),"Firstname is not equals");

    }
}
