package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.BillDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(BillDetailRepository.NAME)
public interface BillDetailRepository extends JpaRepository<BillDetail, String> {
    String NAME = "BaseBillDetailRepository";
}
