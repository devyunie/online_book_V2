package com.bookstore.online.domain.member.service;

import com.bookstore.online.global.error.exception.user.UserNotFoundException;
import org.springframework.stereotype.Service;

import com.bookstore.online.domain.member.Entity.UserEntity;
import com.bookstore.online.domain.member.Entity.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public void userSignUp(UserEntity userEntity) {
    userRepository.save(userEntity);
  }

  public UserEntity findUserId(String userId) {
    return userRepository.findByUserId(userId).orElseThrow(UserNotFoundException::new);
  }
}
