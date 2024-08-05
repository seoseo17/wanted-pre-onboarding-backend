package com.wanted.onboarding.domain.user.service;

import com.wanted.onboarding.common.exception.CustomException;
import com.wanted.onboarding.domain.user.repository.UserRepository;
import com.wanted.onboarding.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.wanted.onboarding.common.response.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public User findById(Long userId){
        return userRepository.findById(userId).orElseThrow(()->new CustomException(USER_NOT_FOUND));
    }
}
