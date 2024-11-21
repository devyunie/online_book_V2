package com.bookstore.online.domain.category.facade;

import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.service.DeleteCategoryService;
import com.bookstore.online.domain.category.service.ReadCategoryService;
import com.bookstore.online.domain.member.Entity.UserEntity;
import com.bookstore.online.domain.member.service.UserService;
import com.bookstore.online.global.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class DeleteCategoryFacade {
  private final DeleteCategoryService deleteCategoryService;
  private final UserService userService;
  private final ReadCategoryService readCategoryService;

  public ResponseEntity<ResponseDto> deleteCategory(Integer categoryNumber, String userId){
      UserEntity userEntity = userService.findUserId(userId);
      CategoryEntity categoryEntity = readCategoryService.findCategoryNumber(categoryNumber);
      if(!userEntity.getUserId().equals(categoryEntity.getUserId())) throw  new Error("작성한 유저자 아닙니다.");
      deleteCategoryService.deleteCategory(categoryNumber);
    return ResponseDto.success();
  }
}
