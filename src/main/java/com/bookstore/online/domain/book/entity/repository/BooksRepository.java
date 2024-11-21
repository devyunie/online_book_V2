package com.bookstore.online.domain.book.entity.repository;

import com.bookstore.online.domain.book.entity.BooksEntity;
import com.bookstore.online.domain.book.entity.resultSet.GetBookOrderCountResultSet;
import com.bookstore.online.domain.book.entity.resultSet.GetUserOrderPurchasedBookResultSet;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<BooksEntity, Integer> {

  Optional<BooksEntity> findByBookNumber(Integer bookNumber);

  @Query(value =
      "SELECT * FROM books " +
          "WHERE category_number=:categoryNumber " +
          "ORDER By :orderSet DESC", nativeQuery = true)
  List<BooksEntity> getBookList(@Param("categoryNumber") Integer categoryNumber,
      @Param("orderSet") String orderSet);

  @Query(value = "SELECT * FROM Books ORDER BY registration_date DESC LIMIT 5", nativeQuery = true)
  List<BooksEntity> getRecentlyBookList();

  @Query(value = "SELECT * FROM books WHERE discount_rate > 0", nativeQuery = true)
  List<BooksEntity> getBookDisCountList();

  @Query("SELECT new com.bookstore.online.domain.book.entity.resultSet.GetBookOrderCountResultSet(oi.bookNumber, COUNT(*)) " +
      "FROM orderItems oi " +
      "GROUP BY oi.bookNumber " +
      "ORDER BY COUNT(*) DESC " +
      "LIMIT 5")
  List<GetBookOrderCountResultSet> getBookOrderCountList();

  @Query("SELECT new com.bookstore.online.domain.book.entity.resultSet.GetUserOrderPurchasedBookResultSet(b.categoryNumber, SUM(oi.quantity)) " +
          "FROM orderItems oi " +
          "JOIN books b ON oi.bookNumber  = b.bookNumber " +
          "JOIN orders o ON oi.orderNumber = o.orderNumber " +
          "WHERE o.userId =:userId " +
          "GROUP BY b.categoryNumber " +
          "ORDER BY SUM(oi.quantity) DESC " +
          "LIMIT 1" )
  GetUserOrderPurchasedBookResultSet PurchasedCategoryBookList(@Param("userId") String userId);
}
