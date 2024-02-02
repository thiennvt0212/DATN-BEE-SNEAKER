package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(ProductDetailRepository.NAME)
public interface ProductDetailRepository extends JpaRepository<ProductDetail, UUID> {
    String NAME = "BaseProductDetailRepository";
}
