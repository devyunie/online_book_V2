package com.bookstore.online.global.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {
  private String code;
  private String message;


  public static ResponseEntity<ResponseDto> success(){
    ResponseDto responseBody = new ResponseDto("SU", "success");
    return ResponseEntity.status(HttpStatus.OK).body(responseBody);
  }

  public static ResponseEntity<ResponseDto> databaseError(){
    ResponseDto responseBody = new ResponseDto("DBA", "DATABASE_ERROR");
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
  }
    public static ResponseEntity<ResponseDto> tokenCreateFail() {
      ResponseDto responseBody = new ResponseDto("TF", "TOKEN_CREATE_FAIL");
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
  }
  public static ResponseEntity<ResponseDto> signInFail() {
    ResponseDto responseBody = new ResponseDto("SF", "SIGN_IN_FAIL");
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
}


}
