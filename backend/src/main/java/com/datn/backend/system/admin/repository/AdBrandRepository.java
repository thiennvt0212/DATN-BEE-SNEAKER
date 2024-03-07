package com.datn.backend.system.admin.repository;

import com.datn.backend.repository.BrandRepository;
import com.datn.backend.system.admin.model.request.FindBrandRequest;
import com.datn.backend.system.admin.model.respone.BrandRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface AdBrandRepository extends BrandRepository {

    @Query(value = """
            SELECT a.id ,a.code, a.name FROM brand a 
            WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
            """,
            countQuery = """
                    SELECT COUNT(1)  FROM brand a 
                     WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
                    """, nativeQuery = true)
    Page<BrandRespone> getAllPage(Pageable pageable, @Param("req") FindBrandRequest req);
}
