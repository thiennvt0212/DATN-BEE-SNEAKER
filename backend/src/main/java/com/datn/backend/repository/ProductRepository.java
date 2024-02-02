package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(ProductRepository.NAME)
public interface ProductRepository extends JpaRepository<Product, UUID> {
    String NAME = "BaseProductRepository";
}
