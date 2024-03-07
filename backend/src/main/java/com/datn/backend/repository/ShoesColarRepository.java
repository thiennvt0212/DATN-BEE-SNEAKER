package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.ShoesColar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(ShoesColarRepository.NAME)
public interface ShoesColarRepository extends JpaRepository<ShoesColar, String> {
    String NAME = "BaseShoesColarRepository";
}
