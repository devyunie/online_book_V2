package com.bookstore.online.global.error.exception;

import com.bookstore.online.global.error.ErrorCode;

public class InternalServerErrorException extends BusinessBaseException {

  public InternalServerErrorException(ErrorCode errorCode) {
    super(errorCode.getMessage(),errorCode);
  }
  public InternalServerErrorException(){
    super(ErrorCode.INTERNAL_SERVER_ERROR);
  }
}
