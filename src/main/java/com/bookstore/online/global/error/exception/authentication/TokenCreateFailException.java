package com.bookstore.online.global.error.exception.authentication;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.InternalServerErrorException;

public class TokenCreateFailException extends InternalServerErrorException {
  public TokenCreateFailException() {super(ErrorCode.TOKEN_CREATE_FAIL);}
}
