package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Color;
import com.datn.backend.system.admin.model.request.AdAccountStRequest;
import com.datn.backend.system.admin.model.request.AdColorRequest;
import com.datn.backend.system.admin.service.AdAcountService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("account")
public class AdAccountController {

    @Autowired
    AdAcountService adAcountService;

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        List<Account> list = adAcountService.getAll();
        System.out.println(list);
        return ResponseEntity.ok(adAcountService.getAll());
    }
    @GetMapping("/gender")
    public ResponseEntity<List<Account>> getAccountsByGender(@RequestParam(required = false) Boolean isMale,
                                                             @RequestParam(required = false) Boolean isFemale) {
        List<Account> accounts;

        if (isMale != null && isMale) {
            // Lọc chỉ nam
            accounts = adAcountService.findAllByGender(true, false);
        } else if (isFemale != null && isFemale) {
            // Lọc chỉ nữ
            accounts = adAcountService.findAllByGender(false, true);
        } else {
            // Hiển thị tất cả
            accounts = adAcountService.getAll();
        }

        return ResponseEntity.ok(accounts);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody AdAccountStRequest adAccountStRequest ){
        Account account = adAcountService.add(adAccountStRequest);
         return ResponseEntity.ok(account);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id){
        return ResponseEntity.ok(adAcountService.delete(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody AdAccountStRequest adAccountStRequest){
        Account account = adAcountService.update(id,adAccountStRequest);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> detail(@PathVariable String id){
        Account account = adAcountService.findById(id);
        return ResponseEntity.ok(account);
    }

}
