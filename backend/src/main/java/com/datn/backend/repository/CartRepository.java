package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(CartRepository.NAME)
public interface CartRepository extends JpaRepository<Cart, UUID> {
    String NAME = "BaseCartRepository";
}
