package com.bookstore.online.domain.member.Facade;

import com.bookstore.online.domain.member.Entity.UserEntity;
import com.bookstore.online.domain.member.Entity.repository.UserRepository;
import com.bookstore.online.domain.member.dto.request.SignInRequestDto;
import com.bookstore.online.domain.member.dto.request.SignUpRequestDto;
import com.bookstore.online.domain.member.dto.response.SignInResponseDto;
import com.bookstore.online.domain.member.service.UserService;
import com.bookstore.online.global.dto.ResponseDto;
import com.bookstore.online.global.provider.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
  private final JwtProvider jwtProvider;
  private final UserService userService;

  public ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto) {
    String userId = dto.getUserId();
    String password = dto.getPassword();
    String email = dto.getEmail();
    String name = dto.getName();
    try{
      String encodedPassword = passwordEncoder.encode(password);
      dto.setPassword(encodedPassword);
      UserEntity userEntity = new UserEntity(dto);
      userService.userSignUp(userEntity);

    }catch (Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return ResponseDto.success();
  }

  public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
    String userId = dto.getUserId();
    String password = dto.getPassword();
    String accessToken = null;
    try{
      UserEntity userEntity = userService.findUserId(userId);
      if(userEntity == null){
        return ResponseDto.signInFail();
      }
      String encodedPassword = userEntity.getPassword();
      boolean isMatched = passwordEncoder.matches(password, encodedPassword);
      if(!isMatched) return ResponseDto.signInFail();

      accessToken = jwtProvider.create(userId);
      if(accessToken == null) return ResponseDto.tokenCreateFail();


    }catch (Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return SignInResponseDto.success(accessToken);
  }
}
