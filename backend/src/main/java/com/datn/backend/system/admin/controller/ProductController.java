package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Brand;
import com.datn.backend.entity.Product;
import com.datn.backend.system.admin.model.request.ProductRequest;
import com.datn.backend.system.admin.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/Products")
    public ResponseEntity<Object> getListProduct(){
        List<Product> Products = productService.getListProduct();
        return ResponseEntity.ok(Products);
    }

    @PostMapping("/Products/create")
    public ResponseEntity<Object> createProduct(@Valid @RequestBody ProductRequest productRequest){
        Product Products = productService.CreateProduct(productRequest);
        return ResponseEntity.ok(Products);
    }

    @PutMapping("/Products/update/{id}")
    public ResponseEntity<Object> update(@RequestBody ProductRequest productRequest, @PathVariable String id){
        Product Products =productService.updateDetailProduct(productRequest, id);
        return ResponseEntity.ok(Products);
    }

    @DeleteMapping("/Products/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        productService.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }

    @GetMapping("/Products/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Product Products = productService.findProductById(id);
        return ResponseEntity.ok(Products);
    }
}
