package com.bookstore.online.global.error;

import com.bookstore.online.global.error.exception.BusinessBaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@ControllerAdvice
public class GlobalExceotionHandler {
//  지원하지 않은 HTTP method 호출 할 경우 발생
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  protected ResponseEntity<ErrorResponse> handle(HttpRequestMethodNotSupportedException e) {
    log.error("HttpRequestMethodNotSupportedException", e);
    return createErrorResponseEntity(ErrorCode.METHOD_NOT_ALLOWED);
  }

  @ExceptionHandler({NoResourceFoundException.class})
  protected ResponseEntity<ErrorResponse> handle(NoResourceFoundException e) {
    log.error("NoResourceFoundException", e);
    return createErrorResponseEntity(ErrorCode.URL_ERROR);
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException e) {
    log.error("MethodArgumentNotValidException", e);
    return createErrorResponseEntity(ErrorCode.INVALID_INTPUT_VALUE);
  }

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<ErrorResponse> handle(Exception e) {
    log.error("Exception", e);
    return createErrorResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BusinessBaseException.class)
  protected ResponseEntity<ErrorResponse> handle(BusinessBaseException e) {
    log.error("BusinessException", e);
    return createErrorResponseEntity(e.getErrorCode());
  }

  private ResponseEntity<ErrorResponse> createErrorResponseEntity(ErrorCode errorCode) {
    return new ResponseEntity<>(ErrorResponse.of(errorCode),errorCode.getStatus());
  }
}
