package com.bookstore.online.domain.book.service;

import com.bookstore.online.domain.book.dto.request.PostCreateBookRequestDto;
import com.bookstore.online.domain.book.entity.BooksEntity;
import com.bookstore.online.domain.book.entity.repository.BooksRepository;
import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateBookService {

  private final BooksRepository booksRepository;

  public void createBook(BooksEntity booksEntity) {
    booksRepository.save(booksEntity);
  }

}
