package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository(AccountRepository.NAME)
public interface AccountRepository extends JpaRepository<Account, String> {
    String NAME = "BaseAccountRepository";
    @Query("SELECT a FROM Account a WHERE a.role = 1 ")
    List<Account> findAllRoleTwo();

    @Query("SELECT a FROM Account a WHERE (:isMale = true AND a.gender = true) OR (:isFemale = true AND a.gender = false)")
    List<Account> findAllByGender(@Param("isMale") boolean isMale, @Param("isFemale") boolean isFemale);
}
