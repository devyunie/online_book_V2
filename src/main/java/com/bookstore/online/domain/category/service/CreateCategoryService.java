package com.bookstore.online.domain.category.service;

import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.entity.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateCategoryService {
  private final CategoryRepository categoryRepository;

  public void createCategory(CategoryEntity categoryEntity) {
    categoryRepository.save(categoryEntity);
  }
}
