package com.bookstore.online.domain.category.facade;


import com.bookstore.online.domain.category.dto.request.PostCreateCategoryRequestDto;
import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.service.CreateCategoryService;
import com.bookstore.online.domain.member.Entity.UserEntity;
import com.bookstore.online.domain.member.service.UserService;
import com.bookstore.online.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class CreateCategoryFacade {

  private final CreateCategoryService createCategoryService;
  private final UserService userService;

  public ResponseEntity<ResponseDto> postCreateCategory(PostCreateCategoryRequestDto dto, String userId) {
    userService.findUserId(userId);
    CategoryEntity categoryEntity = new CategoryEntity(dto, userId);
    createCategoryService.createCategory(categoryEntity);

    return ResponseDto.success();
  }

}
