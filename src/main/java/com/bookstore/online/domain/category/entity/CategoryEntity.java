package com.bookstore.online.domain.category.entity;

import com.bookstore.online.domain.category.dto.request.PatchUpdateCategoryRequestDto;
import com.bookstore.online.domain.category.dto.request.PostCreateCategoryRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "categories")
@Table(name = "categories")
public class CategoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryNumber;
  private String categoryName;
  private String userId;

  public CategoryEntity(PostCreateCategoryRequestDto dto, String userId) {
    this.categoryName = dto.getCategoryName();
    this.userId = userId;
  }

  public void patchCategory(PatchUpdateCategoryRequestDto dto) {
    this.categoryName = dto.getCategoryName();
  }
}
