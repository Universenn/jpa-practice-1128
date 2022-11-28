package com.example.jpapractice.service;

import com.example.jpapractice.domain.UserDto;
import com.example.jpapractice.domain.UserJoinRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserDto join(UserJoinRequest request) {
        return new UserDto("", "", "");
    }
}
