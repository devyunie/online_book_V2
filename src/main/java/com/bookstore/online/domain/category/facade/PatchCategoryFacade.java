package com.bookstore.online.domain.category.facade;

import com.bookstore.online.domain.category.dto.request.PatchUpdateCategoryRequestDto;
import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.service.ReadCategoryService;
import com.bookstore.online.domain.category.service.UpdateCategoryService;
import com.bookstore.online.domain.member.Entity.UserEntity;
import com.bookstore.online.domain.member.service.UserService;
import com.bookstore.online.global.dto.ResponseDto;
import com.bookstore.online.global.error.exception.InternalServerErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.ErrorResponseException;

@Component
@RequiredArgsConstructor
public class PatchCategoryFacade {

  private final UpdateCategoryService updateCategoryService;
  private final ReadCategoryService readCategoryService;
  private final UserService userService;

  public ResponseEntity<ResponseDto> patchCategory(PatchUpdateCategoryRequestDto dto, Integer categoryNumber, String userId) {
    try{
      UserEntity userEntity = userService.findUserId(userId);
      CategoryEntity categoryEntity = readCategoryService.findCategoryNumber(categoryNumber);
      if(!categoryEntity.getUserId().equals(userEntity.getUserId())) throw new Error("작성한 유저가 아닙니다.");
      categoryEntity.patchCategory(dto);
      updateCategoryService.updateCategory(categoryEntity);

    }catch (Exception e){
      e.printStackTrace();
      throw new InternalServerErrorException();
    }
    return ResponseDto.success();
  }
}
