package com.bookstore.online.global.error.exception.authentication;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.ForbiddenException;

public class NoPermissionException extends ForbiddenException {
  public NoPermissionException() {
    super(ErrorCode.NO_PERMISSION);
  }
}
