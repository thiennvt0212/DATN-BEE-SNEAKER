package com.datn.backend.system.admin.service;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.ShoesColar;
import com.datn.backend.system.admin.model.request.AdShoesColarRequest;
import com.datn.backend.system.admin.model.request.FindShoesColarRequest;
import com.datn.backend.system.admin.model.request.FindSoleRequest;
import com.datn.backend.system.admin.model.respone.ShoesColarRespone;

import java.util.List;

public interface AdShoeColarService {

    List<ShoesColar> getAll();

    ShoesColar add(AdShoesColarRequest shoesColarRequest);

    ShoesColar update(String id, AdShoesColarRequest shoesColarRequest);

    String delete(String id);

    ShoesColar findById(String id);

    PageableObject<ShoesColarRespone> getAllPage(FindShoesColarRequest request);

}
