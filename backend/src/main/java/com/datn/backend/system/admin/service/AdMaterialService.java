package com.datn.backend.system.admin.service;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Material;
import com.datn.backend.system.admin.model.request.AdMaterialRequest;
import com.datn.backend.system.admin.model.request.FindBrandRequest;
import com.datn.backend.system.admin.model.request.FindMaterialRequest;
import com.datn.backend.system.admin.model.respone.BrandRespone;
import com.datn.backend.system.admin.model.respone.MaterialRespone;

import java.util.List;

public interface AdMaterialService {

    List<Material> getAll();

    Material add(AdMaterialRequest adMaterialRequest);

    Material update(String id, AdMaterialRequest adMaterialRequest);

    String delete(String id);

    Material findById(String id);

    PageableObject<MaterialRespone> getAllPage(FindMaterialRequest request);

}
