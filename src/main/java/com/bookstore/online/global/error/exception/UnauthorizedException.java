package com.bookstore.online.global.error.exception;

import com.bookstore.online.global.error.ErrorCode;

public class UnauthorizedException extends BusinessBaseException {
  public UnauthorizedException(ErrorCode errorCode) {
    super(errorCode.getMessage(),errorCode);
  }
  public UnauthorizedException(){
    super(ErrorCode.UNAUTHORIZED);
  }
}
