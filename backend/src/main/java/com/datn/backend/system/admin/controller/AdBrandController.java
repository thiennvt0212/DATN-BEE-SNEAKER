package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Brand;
import com.datn.backend.system.admin.model.request.AdBrandRequest;
import com.datn.backend.system.admin.model.request.FindBrandRequest;
import com.datn.backend.system.admin.service.AdBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("brand")
public class AdBrandController {

    @Autowired
    AdBrandService adBrandService;

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<Brand> list = adBrandService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adBrandService.getAll());
//        thiên
    }

    @GetMapping
    public ResponseEntity<?> getAllPage(FindBrandRequest request) {
        return ResponseEntity.ok(adBrandService.getAllPage(request));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdBrandRequest adBrandRequest ){
        Brand brand = adBrandService.add(adBrandRequest);
         return ResponseEntity.ok(brand);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adBrandService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdBrandRequest adBrandRequest){
        Brand brand = adBrandService.update(id,adBrandRequest);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Brand brand = adBrandService.findById(id);
        System.out.println("thien");
        return ResponseEntity.ok(brand);
    }

}
