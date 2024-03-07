package com.datn.backend.system.admin.service;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Product;
import com.datn.backend.system.admin.model.request.AdProductRequest;
import com.datn.backend.system.admin.model.request.FindProductRequest;
import com.datn.backend.system.admin.model.respone.ProductRespone;

import java.util.List;

public interface AdProductService {
    List<Product> getAll();

    Product add(AdProductRequest adProductRequest);

    Product update(String id, AdProductRequest adProductRequest);


    String delete(String id);

    Product findById(String id);

    PageableObject<ProductRespone> getAllPage(FindProductRequest request);
}
