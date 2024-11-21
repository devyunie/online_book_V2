package com.bookstore.online.domain.inventory;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "orderItems")
@Table(name = "order_items")
public class InventoryEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderItemNumber;
  private Integer orderNumber;
  private Integer bookNumber;
  private Integer quantity;
  private Integer pricePerUnit;

}
