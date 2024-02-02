package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Cart;
import com.datn.backend.entity.CartDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(CartDetailRepository.NAME)
public interface CartDetailRepository extends JpaRepository<CartDetail, UUID> {
    String NAME = "BaseCartDetailRepository";
}
