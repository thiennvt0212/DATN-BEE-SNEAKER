package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Size;
import com.datn.backend.system.admin.model.request.AdSizeRequest;
import com.datn.backend.system.admin.service.AdSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("size")
public class AdSizeController {

    @Autowired
    AdSizeService adSizeService;

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<Size> list = adSizeService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adSizeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdSizeRequest adSizeRequest ){
        Size size = adSizeService.add(adSizeRequest);
         return ResponseEntity.ok(size);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adSizeService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdSizeRequest adSizeRequest){
        Size size = adSizeService.update(id,adSizeRequest);
        return ResponseEntity.ok(size);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Size size = adSizeService.findById(id);
        System.out.println("hi");
        return ResponseEntity.ok(size);
    }

}
