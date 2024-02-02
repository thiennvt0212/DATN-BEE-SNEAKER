package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(BillRepository.NAME)
public interface BillRepository extends JpaRepository<Bill, UUID> {
    String NAME = "BaseBillRepository";
}
