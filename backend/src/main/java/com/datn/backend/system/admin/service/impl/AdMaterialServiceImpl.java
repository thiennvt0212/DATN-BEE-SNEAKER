package com.datn.backend.system.admin.service.impl;

import com.datn.backend.entity.Material;
import com.datn.backend.system.admin.model.request.AdMaterialRequest;
import com.datn.backend.system.admin.repository.AdMaterialRepository;
import com.datn.backend.system.admin.service.AdMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdMaterialServiceImpl implements AdMaterialService {

    @Autowired
    private AdMaterialRepository adMaterialRepository;


    @Override
    public List<Material> getAll() {
        return adMaterialRepository.findAll();
    }

    @Override
    public Material add(AdMaterialRequest adMaterialRequest) {
        Material material = new Material();
        material.setCode(adMaterialRequest.getCode());
        material.setName(adMaterialRequest.getName());
        return adMaterialRepository.save(material);

    }

    @Override
    public Material update(String id, AdMaterialRequest adMaterialRequest) {
        Material material = adMaterialRepository.findById(id).get();
        if(material != null){
            material.setCode(adMaterialRequest.getCode());
            material.setName(adMaterialRequest.getName());
        }
        return adMaterialRepository.save(material);    }

    @Override
    public String delete(String id) {
        adMaterialRepository.deleteById(id);
        return id;
    }


    @Override
    public Material findById(String id) {
        Material material = adMaterialRepository.findById(id).get();
        return material;
    }

}
