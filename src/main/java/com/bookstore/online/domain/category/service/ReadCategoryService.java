package com.bookstore.online.domain.category.service;

import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.entity.repository.CategoryRepository;
import com.bookstore.online.global.error.exception.category.CategoryNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadCategoryService {
  private final CategoryRepository categoryRepository;

  public List<CategoryEntity> readCategoryAllList(){
    return categoryRepository.findByOrderByCategoryNameAsc();
  }

  public CategoryEntity findCategoryNumber(Integer categoryNumber){
    return categoryRepository.findByCategoryNumber(categoryNumber).orElseThrow(
        CategoryNotFoundException::new);
  }

}

