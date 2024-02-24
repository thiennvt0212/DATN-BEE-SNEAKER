package com.datn.backend.system.admin.service.impl;

import com.datn.backend.entity.Color;
import com.datn.backend.system.admin.model.request.AdColorRequest;
import com.datn.backend.system.admin.repository.AdcolorRepository;
import com.datn.backend.system.admin.service.AdColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdColorServiceImpl implements AdColorService {

    @Autowired
    private AdcolorRepository adcolorRepository;


    @Override
    public List<Color> getAll() {
        return adcolorRepository.findAll();
    }

    @Override
    public Color add(AdColorRequest adColorRequest) {
        Color color = new Color();
        color.setCode(adColorRequest.getCode());
        color.setName(adColorRequest.getName());
        return adcolorRepository.save(color);

    }

    @Override
    public Color update(String id, AdColorRequest adColorRequest) {
        Color color = adcolorRepository.findById(id).get();
        if(color != null){
            color.setCode(adColorRequest.getCode());
            color.setName(adColorRequest.getName());
        }
        return adcolorRepository.save(color);    }



    @Override
    public String delete(String id) {
        adcolorRepository.deleteById(id);
        return id;
    }

    @Override
    public Color findById(String id) {
        Color color = adcolorRepository.findById(id).get();
        return color;
    }

}
