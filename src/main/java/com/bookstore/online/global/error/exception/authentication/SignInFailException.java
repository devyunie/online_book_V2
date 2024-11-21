package com.bookstore.online.global.error.exception.authentication;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.UnauthorizedException;

public class SignInFailException extends UnauthorizedException {
  public SignInFailException(){super(ErrorCode.SIGN_IN_FAIL);}
}
