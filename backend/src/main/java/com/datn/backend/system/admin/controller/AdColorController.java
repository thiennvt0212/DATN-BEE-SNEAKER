package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Color;
import com.datn.backend.system.admin.model.request.AdColorRequest;
import com.datn.backend.system.admin.service.AdColorService;
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
@RequestMapping("color")
public class AdColorController {

    @Autowired
    AdColorService adColorService;

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<Color> list = adColorService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adColorService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdColorRequest adColorRequest ){
        Color color = adColorService.add(adColorRequest);
         return ResponseEntity.ok(color);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adColorService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdColorRequest adColorRequest){
        Color color = adColorService.update(id,adColorRequest);
        return ResponseEntity.ok(color);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Color color = adColorService.findById(id);
        return ResponseEntity.ok(color);
    }

}
