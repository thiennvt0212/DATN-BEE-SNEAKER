package com.datn.backend.system.admin.service;

import com.datn.backend.entity.Product;
import com.datn.backend.system.admin.model.request.ProductRequest;

import java.util.List;

public interface ProductService {

    List<Product> getListProduct();

    Product CreateProduct(ProductRequest productRequest);

    Product updateDetailProduct(ProductRequest productRequest, String id);

    String delete(String id);

    Product findProductById(String id);
}
