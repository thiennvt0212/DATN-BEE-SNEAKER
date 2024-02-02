package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(SizeRepository.NAME)
public interface SizeRepository extends JpaRepository<Size, UUID> {
    String NAME = "BaseSizeRepository";
}
