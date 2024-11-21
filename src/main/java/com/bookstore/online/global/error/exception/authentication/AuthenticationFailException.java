package com.bookstore.online.global.error.exception.authentication;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.UnauthorizedException;

public class AuthenticationFailException extends UnauthorizedException {
  public AuthenticationFailException() {
    super(ErrorCode.AUTHENTICATION_FAIL);
  }
}
