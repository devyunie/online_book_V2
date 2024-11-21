package com.bookstore.online.global.error.exception.user;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.NotFoundException;

public class UserNotFoundException extends NotFoundException {
  public UserNotFoundException() {
    super(ErrorCode.USER_NOT_FOUND);
  }
}
