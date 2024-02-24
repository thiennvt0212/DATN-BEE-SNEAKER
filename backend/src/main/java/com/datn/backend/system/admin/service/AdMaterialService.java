package com.datn.backend.system.admin.service;

import com.datn.backend.entity.Material;
import com.datn.backend.system.admin.model.request.AdMaterialRequest;

import java.util.List;

public interface AdMaterialService {

    List<Material> getAll();

    Material add(AdMaterialRequest adMaterialRequest);

    Material update(String id, AdMaterialRequest adMaterialRequest);

    String delete(String id);

    Material findById(String id);



}
