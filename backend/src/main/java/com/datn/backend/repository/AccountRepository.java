package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(AccountRepository.NAME)
public interface AccountRepository extends JpaRepository<Account, UUID> {
    String NAME = "BaseAccountRepository";
}
