package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(BrandRepository.NAME)
public interface BrandRepository extends JpaRepository<Brand, String> {
    String NAME = "BaseBrandRepository";

}
