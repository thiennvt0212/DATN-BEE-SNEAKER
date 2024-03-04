package com.datn.backend.system.admin.service.impl;

import com.datn.backend.entity.Product;
import com.datn.backend.system.admin.model.request.ProductRequest;
import com.datn.backend.system.admin.repository.AdProductRepository;
import com.datn.backend.system.admin.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private AdProductRepository adProductRepository;

    @Override
    public List<Product> getListProduct() {
        return adProductRepository.findAll();
    }

    @Override
    public Product CreateProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setCode(productRequest.getCode());
        product.setName(productRequest.getName());
        product.setDescriptions(productRequest.getDescriptions());
        adProductRepository.save(product);
        return product;

    }

    @Override
    public Product updateDetailProduct(ProductRequest productRequest, String id){
        Optional<Product> rs = adProductRepository.findById(id);
        if (rs.isEmpty()) {
            System.out.println("Sản Phẩm không tồn tại");
        }
        Product Product = rs.get();
        Product.setCode(productRequest.getCode());
        Product.setName(productRequest.getName());
        Product.setDescriptions(productRequest.getDescriptions());
        return  adProductRepository.save(Product);
    }

    @Override
    public String delete(String id) {
        adProductRepository.deleteById(id);
        return id;
    }

    @Override
    public Product findProductById(String id) {
        Optional<Product> ProductOptional = adProductRepository.findById(id);
        if (ProductOptional.isEmpty()) {
            System.out.println("Sản Phẩm không tồn tại");
        }
        return ProductOptional.get();
    }
}
