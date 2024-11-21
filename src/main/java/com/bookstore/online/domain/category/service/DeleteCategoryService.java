package com.bookstore.online.domain.category.service;

import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.entity.repository.CategoryRepository;
import com.bookstore.online.domain.member.Entity.UserEntity;
import com.bookstore.online.domain.member.Entity.repository.UserRepository;
import com.bookstore.online.global.error.exception.category.CategoryNotFoundException;
import com.bookstore.online.global.error.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteCategoryService {
  private final CategoryRepository categoryRepository;
  private final UserRepository userRepository;

  public void deleteCategory (Integer categoryNanumber) {
    categoryRepository.deleteById(categoryNanumber);

  }

}
