package com.datn.backend.system.admin.repository;

import com.datn.backend.repository.AccountRepository;
import com.datn.backend.repository.SizeRepository;
import com.datn.backend.system.admin.model.request.FindBrandRequest;
import com.datn.backend.system.admin.model.request.FindSizeRequest;
import com.datn.backend.system.admin.model.respone.BrandRespone;
import com.datn.backend.system.admin.model.respone.SizeRespone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdSizeRepository extends SizeRepository {
    @Query(value = """
            SELECT a.id ,a.code, a.name FROM size a 
            WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
            """,
            countQuery = """
                    SELECT COUNT(1)  FROM size a 
                     WHERE (:#{#req.value} IS NULL OR :#{#req.value} LIKE '' OR a.name LIKE %:#{#req.value}% OR a.code LIKE %:#{#req.value}%) 
                    """, nativeQuery = true)
    Page<SizeRespone> getAllPage(Pageable pageable, @Param("req") FindSizeRequest req);
}
