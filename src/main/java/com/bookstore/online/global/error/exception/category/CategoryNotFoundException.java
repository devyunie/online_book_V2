package com.bookstore.online.global.error.exception.category;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.ForbiddenException;

public class CategoryNotFoundException extends ForbiddenException {
  public CategoryNotFoundException() {
    super(ErrorCode.CATEGORY_NOT_FOUND);
  }

}
