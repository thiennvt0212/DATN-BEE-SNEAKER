package com.datn.backend.system.admin.service.impl;

import com.datn.backend.entity.Brand;
import com.datn.backend.system.admin.model.request.AdBrandRequest;
import com.datn.backend.system.admin.repository.AdBrandRepository;
import com.datn.backend.system.admin.service.AdBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AdBrandServiceImpl implements AdBrandService {

    @Autowired
    private AdBrandRepository adBrandRepository;


    public  Long changeDateTime(LocalDateTime localDateTime){
        localDateTime = LocalDateTime.now();
        long longValue = localDateTime.toEpochSecond(java.time.ZoneOffset.ofHours(0));
        return longValue;
    }


    @Override
    public List<Brand> getAll() {
        return adBrandRepository.findAll();
    }

    @Override
    public Brand add(AdBrandRequest brandRequest) {
        Brand brand = new Brand();
        LocalDateTime localDateTime = LocalDateTime.now();
        long dateTime = changeDateTime(localDateTime);
        brand.setCreatedDate(dateTime);
        brand.setCode(brandRequest.getCode());
        brand.setName(brandRequest.getName());
        return adBrandRepository.save(brand);
    }

    @Override
    public Brand update(String id, AdBrandRequest brandRequest) {
        Brand brand = adBrandRepository.findById(id).get();
        if(brand != null){
            brand.setCode(brandRequest.getCode());
            brand.setName(brandRequest.getName());
        }
        return adBrandRepository.save(brand);
    }

    @Override
    public String delete(String id) {
        adBrandRepository.deleteById(id);
        return id;
    }

    @Override
    public Brand findById(String id) {
        Brand brand = adBrandRepository.findById(id).get();
        return brand;
    }

}
