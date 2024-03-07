package com.datn.backend.system.admin.service;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Size;
import com.datn.backend.system.admin.model.request.AdSizeRequest;
import com.datn.backend.system.admin.model.request.FindMaterialRequest;
import com.datn.backend.system.admin.model.request.FindSizeRequest;
import com.datn.backend.system.admin.model.respone.MaterialRespone;
import com.datn.backend.system.admin.model.respone.SizeRespone;

import java.util.List;

public interface AdSizeService {

    List<Size> getAll();

    Size add(AdSizeRequest sizeRequest);

    Size update(String id, AdSizeRequest sizeRequest);

    String delete(String id);

    Size findById(String id);

    PageableObject<SizeRespone> getAllPage(FindSizeRequest request);

}
