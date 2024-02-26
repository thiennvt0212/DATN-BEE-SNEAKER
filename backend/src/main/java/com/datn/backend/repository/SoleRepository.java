package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Sole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(SoleRepository.NAME)
public interface SoleRepository extends JpaRepository<Sole, String> {
    String NAME = "BaseSoleRepository";
}
