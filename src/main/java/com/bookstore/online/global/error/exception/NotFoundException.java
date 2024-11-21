package com.bookstore.online.global.error.exception;

import com.bookstore.online.global.error.ErrorCode;

public class NotFoundException extends BusinessBaseException {

  public NotFoundException(ErrorCode errorCode) {
    super(errorCode.getMessage(), errorCode);
  }

  public NotFoundException() {
    super(ErrorCode.NOT_FOUND);
  }
}
