package com.example.jpapractice.service;

import com.example.jpapractice.domain.User;
import com.example.jpapractice.domain.UserDto;
import com.example.jpapractice.domain.UserJoinRequest;
import com.example.jpapractice.exception.ErrorCode;
import com.example.jpapractice.exception.HospitalReviewAppException;
import com.example.jpapractice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.jpapractice.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto join(UserJoinRequest request) {
        // 비지니스 로직
        // userName 유무 체크
        // orElseThrow 없을때 에러 사용
        // userRepository.findByUserName(request.getUserName()).orElseThrow(()-> new RuntimeException("사용중인 이름입니다."));
        // ifPresent 없을때 에러 사용
        userRepository.findByUserName(request.getUserName())
                .ifPresent(user -> {
                    throw new HospitalReviewAppException(DUPLICATED_USER_NAME, String.format("UserName : %s", request.getUserName()));
                });
        //  회원가입 save
        User savedUser = userRepository.save(request.toEntity());

        return UserDto.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .email(savedUser.getEmailAddress())
                .build();
    }
}
