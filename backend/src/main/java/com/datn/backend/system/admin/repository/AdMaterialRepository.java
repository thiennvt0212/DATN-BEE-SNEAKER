package com.datn.backend.system.admin.repository;

import com.datn.backend.repository.AccountRepository;
import com.datn.backend.repository.MaterialRepository;
import com.datn.backend.system.admin.model.request.FindMaterialRequest;
import com.datn.backend.system.admin.model.request.FindSizeRequest;
import com.datn.backend.system.admin.model.respone.MaterialRespone;
import com.datn.backend.system.admin.model.respone.SizeRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdMaterialRepository extends MaterialRepository {
    @Query(value = """
            SELECT a.id ,a.code, a.name FROM material a 
            WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
            """,
            countQuery = """
                    SELECT COUNT(1)  FROM material a 
                     WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
                    """, nativeQuery = true)
    Page<MaterialRespone> getAllPage(Pageable pageable, @Param("req") FindMaterialRequest req);
}
