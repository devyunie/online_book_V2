package com.bookstore.online.domain.book.facade;

import static org.springframework.http.ResponseEntity.internalServerError;

import com.bookstore.online.domain.book.dto.request.PostCreateBookRequestDto;
import com.bookstore.online.domain.book.entity.BooksEntity;
import com.bookstore.online.domain.book.service.CreateBookService;
import com.bookstore.online.domain.book.service.ReadBookService;
import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.service.ReadCategoryService;
import com.bookstore.online.domain.member.Entity.UserEntity;
import com.bookstore.online.domain.member.service.UserService;
import com.bookstore.online.global.dto.ResponseDto;
import com.bookstore.online.global.error.exception.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@RequiredArgsConstructor
public class CreateBookFacade {
  private final CreateBookService createBookService;
  private final ReadCategoryService readCategoryService;
  private final UserService userService;

  public ResponseEntity<ResponseDto> postCreateBook(PostCreateBookRequestDto dto, String userId){
    try{
      readCategoryService.findCategoryNumber(dto.getCategoryNumber());
      userService.findUserId(userId);
      BooksEntity booksEntity = new BooksEntity(dto, userId);
      createBookService.createBook(booksEntity);
    }catch (Exception exception){
      exception.printStackTrace();
      return ResponseEntity.internalServerError().build();
    }
    return ResponseDto.success();
  }
}
