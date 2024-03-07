package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Brand;
import com.datn.backend.entity.ShoesColar;
import com.datn.backend.system.admin.model.request.AdBrandRequest;
import com.datn.backend.system.admin.model.request.AdShoesColarRequest;
import com.datn.backend.system.admin.model.request.FindBrandRequest;
import com.datn.backend.system.admin.model.request.FindShoesColarRequest;
import com.datn.backend.system.admin.service.AdShoeColarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("shoesColar")
public class AdShoesColarController {

    @Autowired
    AdShoeColarService adShoeColarService;

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<ShoesColar> list = adShoeColarService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adShoeColarService.getAll());
//        thiên
    }

    @GetMapping
    public ResponseEntity<?> getAllPage(FindShoesColarRequest request) {
        return ResponseEntity.ok(adShoeColarService.getAllPage(request));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdShoesColarRequest adShoesColarRequest ){
        ShoesColar shoesColar = adShoeColarService.add(adShoesColarRequest);
         return ResponseEntity.ok(shoesColar);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adShoeColarService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdShoesColarRequest adShoesColarRequest){
        ShoesColar shoesColar = adShoeColarService.update(id,adShoesColarRequest);
        return ResponseEntity.ok(shoesColar);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        ShoesColar shoesColar = adShoeColarService.findById(id);
        System.out.println("thien");
        return ResponseEntity.ok(shoesColar);
    }

}
