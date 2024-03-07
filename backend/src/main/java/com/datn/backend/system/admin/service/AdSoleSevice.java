package com.datn.backend.system.admin.service;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Sole;
import com.datn.backend.system.admin.model.request.AdSoleRequest;
import com.datn.backend.system.admin.model.request.FindSizeRequest;
import com.datn.backend.system.admin.model.request.FindSoleRequest;
import com.datn.backend.system.admin.model.respone.SizeRespone;
import com.datn.backend.system.admin.model.respone.SoleRespone;

import java.util.List;

public interface AdSoleSevice {
    List<Sole> getAll();

    Sole add(AdSoleRequest adSoleRequest);

    Sole update(String id, AdSoleRequest adSoleRequest);

    String delete(String id);

    Sole findById(String id);

    PageableObject<SoleRespone> getAllPage(FindSoleRequest request);
}
