package com.bookstore.online.domain.book.entity;

import com.bookstore.online.domain.book.dto.request.PatchUpdateBookRequestDto;
import com.bookstore.online.domain.book.dto.request.PostCreateBookRequestDto;
import com.bookstore.online.global.CustomDate.CustomDate;
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
@Entity(name = "books")
@Table(name = "books")
public class BooksEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer bookNumber;
  private String bookName;
  private String author;
  private Integer bookPrice;
  private Integer discountRate;
  private String publisher;
  private String publishingDate;
  private String registrationDate;
  private Integer categoryNumber;
  private Integer bookCount;
  private String userId;

  public BooksEntity(PostCreateBookRequestDto dto, String userId) {
    this.bookName = dto.getBookName();
    this.author = dto.getAuthor();
    this.bookPrice = dto.getBookPrice();
    this.discountRate = dto.getDiscountRate();
    this.publisher = dto.getPublisher();
    this.publishingDate = dto.getPublishingDate();
    this.registrationDate = CustomDate.LocalDateTimeFormat();
    this.categoryNumber = dto.getCategoryNumber();
    this.bookCount = dto.getBookCount();
    this.userId = userId;
  }

  public void patch (PatchUpdateBookRequestDto dto){
    this.bookName = dto.getBookName();
    this.author = dto.getAuthor();
    this.bookPrice = dto.getBookPrice();
    this.discountRate = dto.getDiscountRate();
    this.publisher = dto.getPublisher();
    this.publishingDate = dto.getPublishingDate();
    this.registrationDate = CustomDate.LocalDateTimeFormat();
    this.categoryNumber = dto.getCategoryNumber();
    this.bookCount = dto.getBookCount();
  }
}
