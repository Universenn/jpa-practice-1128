package com.example.jpapractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserJoinRequest {
    private String userName;
    private String password;
    private String email;

    public User toEntity() {
        return User.builder()
                .userName(userName)
                .password(password)
                .emailAddress(email)
                .build();
    }
}