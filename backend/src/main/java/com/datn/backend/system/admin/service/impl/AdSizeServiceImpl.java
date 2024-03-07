package com.datn.backend.system.admin.service.impl;

import com.datn.backend.common.PageableObject;
import com.datn.backend.entity.Size;
import com.datn.backend.system.admin.model.request.AdSizeRequest;
import com.datn.backend.system.admin.model.request.FindSizeRequest;
import com.datn.backend.system.admin.model.respone.SizeRespone;
import com.datn.backend.system.admin.repository.AdSizeRepository;
import com.datn.backend.system.admin.service.AdSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdSizeServiceImpl implements AdSizeService {
    @Autowired
    private AdSizeRepository adSizeRepository;

    @Override
    public List<Size> getAll() {
        return adSizeRepository.findAll();
    }

    @Override
    public Size add(AdSizeRequest sizeRequest) {
        Size size = new Size();
        size.setCode(sizeRequest.getCode());
        size.setName(sizeRequest.getName());
        return adSizeRepository.save(size);
    }

    @Override
    public Size update(String id, AdSizeRequest sizeRequest) {
        Size size = adSizeRepository.findById(id).get();
        if (size!=null){
            size.setCode(sizeRequest.getCode());
            size.setName(sizeRequest.getName());
        }
        return adSizeRepository.save(size);
    }

    @Override
    public String delete(String id) {
        adSizeRepository.deleteById(id);
        return id;
    }

    @Override
    public Size findById(String id) {
        Size size=adSizeRepository.findById(id).get();
        return size;
    }

    @Override
    public PageableObject<SizeRespone> getAllPage(FindSizeRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return new PageableObject<>(adSizeRepository.getAllPage(pageable, request));
    }
}
