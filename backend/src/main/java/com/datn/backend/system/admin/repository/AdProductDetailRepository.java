package com.datn.backend.system.admin.repository;

import com.datn.backend.repository.AccountRepository;
import com.datn.backend.repository.ProductDetailRepository;
import com.datn.backend.system.admin.model.respone.ProductDetailRespone;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdProductDetailRepository extends ProductDetailRepository {
    @Query(value = """
              Select pd.id, pd.price , pd.quantity, pd.status, pr.name as nameProduct, pr.descriptions, br.name as nameBrand, sc.name as nameShoeColar, cl.name as nameColor,
                mt.name as nameMaterial, sz.name as nameSize, sl.name as nameSole
                from product_detail pd\s
                join product pr on pd.product_id = pr.id
                join brand br on pd.brand_id = br.id
                join shoes_colar sc on pd.shoes_colar_id = sc.id
                join color cl on pd.color_id = cl.id
                join material mt on pd.material_id = mt.id
                join size sz on pd.size_id = sz.id
                join sole sl on pd.sole_id = sl.id
            """, nativeQuery = true)
    List<ProductDetailRespone> getCutomProduct();
}
