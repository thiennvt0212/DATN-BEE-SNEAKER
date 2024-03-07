package com.datn.backend.system.admin.service;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Color;
import com.datn.backend.system.admin.model.request.AdColorRequest;
import com.datn.backend.system.admin.model.request.FindColorRequest;
import com.datn.backend.system.admin.model.respone.ColorRespone;

import java.util.List;

public interface AdColorService {

    List<Color> getAll();

    Color add(AdColorRequest adColorRequest);

    Color update(String id, AdColorRequest adColorRequest);

    String delete(String id);

    Color findById(String id);

    PageableObject<ColorRespone> getAllPage(FindColorRequest request);


}
