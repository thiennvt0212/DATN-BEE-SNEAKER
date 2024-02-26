package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Sole;
import com.datn.backend.system.admin.model.request.AdSoleRequest;
import com.datn.backend.system.admin.service.AdSoleSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("sole")
public class AdSoleController {
    @Autowired
    private AdSoleSevice adSoleSevice;
    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<Sole> list = adSoleSevice.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adSoleSevice.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdSoleRequest adSoleRequest ){
        Sole sole = adSoleSevice.add(adSoleRequest);
        return ResponseEntity.ok(sole);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adSoleSevice.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdSoleRequest adSoleRequest){
        Sole sole = adSoleSevice.update(id,adSoleRequest);
        return ResponseEntity.ok(sole);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Sole sole = adSoleSevice.findById(id);
        System.out.println("hi");
        return ResponseEntity.ok(sole);
    }
}
