package com.bookstore.online.domain.orders;

import com.bookstore.online.domain.member.Entity.UserEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<OrdersEntity, Integer> {
  List<OrdersEntity> findByUserId(String userId);
}
