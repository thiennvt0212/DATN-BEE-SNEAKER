package com.datn.backend.system.admin.service.impl;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Sole;
import com.datn.backend.system.admin.model.request.AdSoleRequest;
import com.datn.backend.system.admin.model.request.FindSoleRequest;
import com.datn.backend.system.admin.model.respone.SoleRespone;
import com.datn.backend.system.admin.repository.AdSoleRepository;
import com.datn.backend.system.admin.service.AdSoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdSoleServiceImpl implements AdSoleSevice {
    @Autowired
    private AdSoleRepository adSoleRepository;
    @Override
    public List<Sole> getAll() {
        return adSoleRepository.findAll();
    }

    @Override
    public Sole add(AdSoleRequest adSoleRequest) {
        Sole sole = new Sole();
        sole.setCode(adSoleRequest.getCode());
        sole.setName(adSoleRequest.getName());
        return adSoleRepository.save(sole);
    }

    @Override
    public Sole update(String id, AdSoleRequest adSoleRequest) {
        Sole sole = adSoleRepository.findById(id).get();
        if(sole != null){
            sole.setCode(adSoleRequest.getCode());
            sole.setName(adSoleRequest.getName());
        }
        return adSoleRepository.save(sole);
    }

    @Override
    public String delete(String id) {
        adSoleRepository.deleteById(id);
        return id;
    }

    @Override
    public Sole findById(String id) {
        Sole sole =adSoleRepository.findById(id).get();
        return sole;
    }

    @Override
    public PageableObject<SoleRespone> getAllPage(FindSoleRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return new PageableObject<>(adSoleRepository.getAllPage(pageable, request));
    }


}
