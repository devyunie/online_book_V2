package com.bookstore.online.domain.member.controller;

import com.bookstore.online.domain.member.Facade.UserFacade;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.online.domain.member.dto.request.SignInRequestDto;
import com.bookstore.online.domain.member.dto.request.SignUpRequestDto;
import com.bookstore.online.domain.member.dto.response.SignInResponseDto;
import com.bookstore.online.domain.member.service.UserService;
import com.bookstore.online.global.dto.ResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;

    @PostMapping("/register")
    public ResponseEntity<ResponseDto> signUp(
            @RequestBody @Valid SignUpRequestDto requestBody
    ){
        ResponseEntity<ResponseDto> response = userFacade.signUp(requestBody);
        return response;
    }

    @PostMapping("/login")
    public ResponseEntity<? super SignInResponseDto> login(
            @RequestBody @Valid SignInRequestDto requestBody
    ){
        ResponseEntity<? super SignInResponseDto> response = userFacade.signIn(requestBody);
        return response;
    }
}

