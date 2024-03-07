package com.datn.backend.system.admin.service.impl;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Brand;
import com.datn.backend.entity.Product;
import com.datn.backend.system.admin.model.request.AdBrandRequest;
import com.datn.backend.system.admin.model.request.AdProductRequest;
import com.datn.backend.system.admin.model.request.FindBrandRequest;
import com.datn.backend.system.admin.model.request.FindProductRequest;
import com.datn.backend.system.admin.model.respone.BrandRespone;
import com.datn.backend.system.admin.model.respone.ProductRespone;
import com.datn.backend.system.admin.repository.AdProductRepository;
import com.datn.backend.system.admin.service.AdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdProductServiceImpl implements AdProductService {

    @Autowired
    private AdProductRepository adProductRepository;

    @Override
    public List<Product> getAll() {
        return adProductRepository.findAll();
    }

    @Override
    public Product add(AdProductRequest productRequest) {
        Product product =  new Product();
        product.setCode(productRequest.getCode());
        product.setName(productRequest.getName());
        return adProductRepository.save(product);
    }

    @Override
    public Product update(String id, AdProductRequest productRequest) {
        Product product = adProductRepository.findById(id).get();
        if(product != null){
            product.setCode(productRequest.getCode());
            product.setName(productRequest.getName());
        }
        return adProductRepository.save(product);
    }

    @Override
    public String delete(String id) {
        adProductRepository.deleteById(id);
        return id;
    }

    @Override
    public Product findById(String id) {
        Product product = adProductRepository.findById(id).get();
        return product;
    }

    @Override
    public PageableObject<ProductRespone> getAllPage(FindProductRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return new PageableObject<>(adProductRepository.getAllPage(pageable, request));
    }
}
