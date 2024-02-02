package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(ColorRepository.NAME)
public interface ColorRepository extends JpaRepository<Color, UUID> {
    String NAME = "BaseColorRepository";
}
