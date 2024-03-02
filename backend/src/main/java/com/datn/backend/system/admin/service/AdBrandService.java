package com.datn.backend.system.admin.service;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Brand;
import com.datn.backend.system.admin.model.request.AdBrandRequest;
import com.datn.backend.system.admin.model.request.FindBrandRequest;
import com.datn.backend.system.admin.model.respone.BrandRespone;
import com.datn.backend.system.admin.service.impl.AdBrandServiceImpl;

import java.util.List;
import java.util.UUID;

public interface AdBrandService {

    List<Brand> getAll();

    Brand add(AdBrandRequest brandRequest);

    Brand update(String id, AdBrandRequest brandRequest);

    String delete(String id);

    Brand findById(String id);

    PageableObject<BrandRespone> getAllPage(FindBrandRequest request);



}
