package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Material;
import com.datn.backend.system.admin.model.request.AdMaterialRequest;
import com.datn.backend.system.admin.model.request.FindColorRequest;
import com.datn.backend.system.admin.model.request.FindMaterialRequest;
import com.datn.backend.system.admin.service.AdMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("material")
public class AdMaterialController {

    @Autowired
    AdMaterialService adMaterialService;

    @GetMapping
    public ResponseEntity<?> getAllPage(FindMaterialRequest request) {
        return ResponseEntity.ok(adMaterialService.getAllPage(request));
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<Material> list = adMaterialService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adMaterialService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdMaterialRequest adMaterialRequest ){
        Material material = adMaterialService.add(adMaterialRequest);
         return ResponseEntity.ok(material);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adMaterialService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdMaterialRequest adMaterialRequest){
        Material material = adMaterialService.update(id,adMaterialRequest);
        return ResponseEntity.ok(material);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Material material = adMaterialService.findById(id);
        return ResponseEntity.ok(material);
    }

}
