package com.bookstore.online.global.error.exception.book;

import com.bookstore.online.global.error.ErrorCode;
import com.bookstore.online.global.error.exception.ForbiddenException;
import com.bookstore.online.global.error.exception.NotFoundException;

public class BookNotFoundException extends NotFoundException {
  public BookNotFoundException() {
    super(ErrorCode.BOOK_NOT_FOUND);
  }
}
