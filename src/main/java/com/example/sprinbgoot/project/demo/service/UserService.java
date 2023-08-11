package com.example.sprinbgoot.project.demo.service;

import com.example.sprinbgoot.project.demo.dto.UserDto;
import com.example.sprinbgoot.project.demo.entity.User;
import com.example.sprinbgoot.project.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
