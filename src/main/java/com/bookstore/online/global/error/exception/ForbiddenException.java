package com.bookstore.online.global.error.exception;
import com.bookstore.online.global.error.ErrorCode;

public class ForbiddenException extends BusinessBaseException {
  public ForbiddenException(ErrorCode errorCode) {
    super(errorCode.getMessage(),errorCode);
  }
  public ForbiddenException(){
    super(ErrorCode.FORBIDDEN);
  }

}
