package com.bookstore.online.domain.inventory.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostOrderItemsRequestDto {

  @NotNull(message = "책 번호는 필수 항목입니다.")
  private Integer bookNumber;

  @NotNull(message = "수량은 필수 항목입니다.")
  @Min(value = 1, message = "수량은 1 이상이어야 합니다.")
  private Integer quantity;
}
