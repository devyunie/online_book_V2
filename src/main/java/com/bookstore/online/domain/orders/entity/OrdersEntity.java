package com.bookstore.online.domain.orders;

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
@Entity(name = "orders")
@Table(name = "orders")
public class OrdersEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orderNumber;
  private String userId;
  private String orderDate;
  private Integer totalPrice;
  private String status;
}
