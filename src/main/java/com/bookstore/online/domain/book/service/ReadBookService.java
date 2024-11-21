package com.bookstore.online.domain.book.service;

import com.bookstore.online.domain.book.entity.BooksEntity;
import com.bookstore.online.domain.book.entity.repository.BooksRepository;
import com.bookstore.online.domain.book.entity.resultSet.GetBookOrderCountResultSet;
import com.bookstore.online.domain.book.entity.resultSet.GetUserOrderPurchasedBookResultSet;
import com.bookstore.online.domain.category.entity.CategoryEntity;
import com.bookstore.online.domain.category.entity.repository.CategoryRepository;
import com.bookstore.online.domain.orders.OrdersEntity;
import com.bookstore.online.domain.orders.OrdersRepository;
import com.bookstore.online.global.error.exception.book.BookNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadBookService {

  private final BooksRepository booksRepository;
  private final OrdersRepository ordersRepository;

  public BooksEntity findBookNumber(Integer bookNumber) {
    return booksRepository.findByBookNumber(bookNumber).orElseThrow(BookNotFoundException::new);
  }

  public List<BooksEntity> BookList() {
    return booksRepository.findAll();
  }

  public List<BooksEntity> searchBookList(Integer categoryNumber, String orderSet) {
    return booksRepository.getBookList(categoryNumber, orderSet);
  }

  public List<BooksEntity> findBookDiscountList() {
    return booksRepository.getBookDisCountList();
  }

  public List<GetBookOrderCountResultSet> bookOrderCount() {
    return booksRepository.getBookOrderCountList();
  }

  public List<BooksEntity> resentlyBookList(){
    return booksRepository.getRecentlyBookList();
  }

  public GetUserOrderPurchasedBookResultSet userPurchasedBookList(String userId){
    return booksRepository.PurchasedCategoryBookList(userId);
  }

}
