package com.datn.backend.system.admin.repository;

import com.datn.backend.repository.AccountRepository;
import com.datn.backend.repository.ShoesColarRepository;
import com.datn.backend.system.admin.model.request.FindMaterialRequest;
import com.datn.backend.system.admin.model.request.FindShoesColarRequest;
import com.datn.backend.system.admin.model.respone.MaterialRespone;
import com.datn.backend.system.admin.model.respone.ShoesColarRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdShoesColarRepository extends ShoesColarRepository {
    @Query(value = """
            SELECT a.id ,a.code, a.name FROM shoes_colar a 
            WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
            """,
            countQuery = """
                    SELECT COUNT(1)  FROM shoes_colar a 
                     WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
                    """, nativeQuery = true)
    Page<ShoesColarRespone> getAllPage(Pageable pageable, @Param("req") FindShoesColarRequest req);
}
