package com.datn.backend.system.admin.service;

import com.datn.backend.entity.Size;
import com.datn.backend.system.admin.model.request.AdSizeRequest;

import java.util.List;

public interface AdSizeService {

    List<Size> getAll();

    Size add(AdSizeRequest sizeRequest);

    Size update(String id, AdSizeRequest sizeRequest);

    String delete(String id);

    Size findById(String id);



}
