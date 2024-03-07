package com.datn.backend.system.admin.repository;

import com.datn.backend.repository.ColorRepository;
import com.datn.backend.system.admin.model.request.FindColorRequest;
import com.datn.backend.system.admin.model.request.FindMaterialRequest;
import com.datn.backend.system.admin.model.respone.ColorRespone;
import com.datn.backend.system.admin.model.respone.MaterialRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdcolorRepository extends ColorRepository {
    @Query(value = """
            SELECT a.id ,a.code, a.name FROM color a 
            WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
            """,
            countQuery = """
                    SELECT COUNT(1)  FROM color a 
                     WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
                    """, nativeQuery = true)
    Page<ColorRespone> getAllPage(Pageable pageable, @Param("req") FindColorRequest req);
}
