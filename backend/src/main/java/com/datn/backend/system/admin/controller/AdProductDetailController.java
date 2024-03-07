package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Product;
import com.datn.backend.system.admin.model.respone.ProductDetailRespone;
import com.datn.backend.system.admin.model.respone.ProductRespone;
import com.datn.backend.system.admin.service.AdProductDetailService;
import com.datn.backend.system.admin.service.AdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("productDetail")
public class AdProductDetailController {

    @Autowired
    AdProductDetailService adProductDetailService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        List<ProductDetailRespone> list = adProductDetailService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adProductDetailService.getAll());
    }

}
