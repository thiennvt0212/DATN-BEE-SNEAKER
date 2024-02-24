package com.datn.backend.system.admin.service;

import com.datn.backend.entity.Color;
import com.datn.backend.system.admin.model.request.AdColorRequest;

import java.util.List;

public interface AdColorService {

    List<Color> getAll();

    Color add(AdColorRequest adColorRequest);

    Color update(String id, AdColorRequest adColorRequest);

    String delete(String id);

    Color findById(String id);



}
