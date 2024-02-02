package com.datn.backend.repository;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository(ImageRepository.NAME)
public interface ImageRepository extends JpaRepository<Image, UUID> {
    String NAME = "BaseImageRepository";
}
