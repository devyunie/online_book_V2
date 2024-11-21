package com.bookstore.online.global.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
  INVALID_INTPUT_VALUE(HttpStatus.BAD_REQUEST, "E1", "올바르지 않은 입력값입니다."),
  METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "E2", "잘못된 HTTP 메서드를 호출했습니다."),
  INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "E3", "서버 에러가 발생했습니다."),
  NOT_FOUND(HttpStatus.NOT_FOUND, "E4", "존재하지 않는 엔티티입니다."),
  UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"E5","인증에 실패했습니다."),
  FORBIDDEN(HttpStatus.FORBIDDEN,"E6","권한이 없습니다"),
  URL_ERROR(HttpStatus.BAD_REQUEST,"E7","URL주소가 올바르지 않습니다."),
  BOOK_NOT_FOUND(HttpStatus.NOT_FOUND, "B1", "존재하지 않는 도서입니다."),
  CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"C1","존재하지 않는 카테고리 입니다."),
  REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND,"R1","리뷰가 존재하지 않습니다."),
  USER_NOT_FOUND(HttpStatus.NOT_FOUND, "U2", "존재하지 않은 유저 입니다."),

  SIGN_IN_FAIL(HttpStatus.UNAUTHORIZED, "S1","로그인에 실패하셨습니다."),
  AUTHENTICATION_FAIL(HttpStatus.UNAUTHORIZED,"A1","인증에 실패하셨습니다"),
  NO_PERMISSION(HttpStatus.FORBIDDEN,"A3","권한이 없습니다."),
  TOKEN_CREATE_FAIL(HttpStatus.INTERNAL_SERVER_ERROR,"A2","토큰 생성에 실패하셨습니다");


  private final String message;

  private final String code;
  private final HttpStatus status;

  ErrorCode(final HttpStatus status, final String code, final String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
