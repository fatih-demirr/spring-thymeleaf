package com.example.springboot.project.demo.service;

import com.example.springboot.project.demo.dto.UserDto;
import com.example.springboot.project.demo.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
