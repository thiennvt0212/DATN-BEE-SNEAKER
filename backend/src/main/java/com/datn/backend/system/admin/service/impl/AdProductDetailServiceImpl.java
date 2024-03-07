package com.datn.backend.system.admin.service.impl;

import com.datn.backend.system.admin.model.respone.ProductDetailRespone;
import com.datn.backend.system.admin.repository.AdProductDetailRepository;
import com.datn.backend.system.admin.repository.AdProductRepository;
import com.datn.backend.system.admin.service.AdProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdProductDetailServiceImpl implements AdProductDetailService {

    @Autowired
    private AdProductDetailRepository adProductDetailRepository;

    @Override
    public List<ProductDetailRespone> getAll() {
        return adProductDetailRepository.getCutomProduct();
    }
}
