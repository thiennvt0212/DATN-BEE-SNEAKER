package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(MaterialRepository.NAME)
public interface MaterialRepository extends JpaRepository<Material, UUID> {
    String NAME = "BaseMaterialRepository";
}
