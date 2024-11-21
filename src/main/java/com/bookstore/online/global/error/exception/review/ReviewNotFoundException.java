package com.bookstore.online.global.error.exception.review;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.NotFoundException;

public class ReviewNotFoundException extends NotFoundException {
  public ReviewNotFoundException() {
    super(ErrorCode.REVIEW_NOT_FOUND);
  }


}
