package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Brand;
import com.datn.backend.entity.Product;
import com.datn.backend.system.admin.model.request.AdBrandRequest;
import com.datn.backend.system.admin.model.request.AdProductRequest;
import com.datn.backend.system.admin.model.request.FindProductRequest;
import com.datn.backend.system.admin.service.AdProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("product")
public class AdProductController {

    @Autowired
    AdProductService adProductService;

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<Product> list = adProductService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adProductService.getAll());
//        thiên
    }

    @GetMapping
    public ResponseEntity<?> getAllPage(FindProductRequest request) {
        return ResponseEntity.ok(adProductService.getAllPage(request));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdProductRequest adProductRequest ){
        Product product = adProductService.add(adProductRequest);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adProductService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdProductRequest adProductRequest){
        Product product = adProductService.update(id,adProductRequest);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Product product = adProductService.findById(id);
        System.out.println("thien");
        return ResponseEntity.ok(product);
    }
}
