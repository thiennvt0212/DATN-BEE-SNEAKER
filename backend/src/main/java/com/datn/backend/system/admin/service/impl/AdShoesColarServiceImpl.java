package com.datn.backend.system.admin.service.impl;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Brand;
import com.datn.backend.entity.ShoesColar;
import com.datn.backend.system.admin.model.request.*;
import com.datn.backend.system.admin.model.respone.BrandRespone;
import com.datn.backend.system.admin.model.respone.ShoesColarRespone;
import com.datn.backend.system.admin.repository.AdBrandRepository;
import com.datn.backend.system.admin.repository.AdShoesColarRepository;
import com.datn.backend.system.admin.service.AdBrandService;
import com.datn.backend.system.admin.service.AdShoeColarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdShoesColarServiceImpl implements AdShoeColarService {

    @Autowired
    private AdShoesColarRepository adShoesColarRepository;

    @Override
    public List<ShoesColar> getAll() {
        return adShoesColarRepository.findAll();
    }

    @Override
    public ShoesColar add(AdShoesColarRequest shoesColarRequest) {
        ShoesColar shoesColar = new ShoesColar();
        shoesColar.setCode(shoesColarRequest.getCode());
        shoesColar.setName(shoesColarRequest.getName());
        return adShoesColarRepository.save(shoesColar);
    }

    @Override
    public ShoesColar update(String id, AdShoesColarRequest shoesColarRequest) {
        ShoesColar shoesColar = adShoesColarRepository.findById(id).get();
        if(shoesColar != null){
            shoesColar.setCode(shoesColarRequest.getCode());
            shoesColar.setName(shoesColarRequest.getName());
        }
        return adShoesColarRepository.save(shoesColar);
    }

    @Override
    public String delete(String id) {
        adShoesColarRepository.deleteById(id);
        return id;
    }

    @Override
    public ShoesColar findById(String id) {
        ShoesColar shoesColar = adShoesColarRepository.findById(id).get();
        return shoesColar;
    }

    @Override
    public PageableObject<ShoesColarRespone> getAllPage(FindShoesColarRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return new PageableObject<>(adShoesColarRepository.getAllPage(pageable, request));
    }

}
