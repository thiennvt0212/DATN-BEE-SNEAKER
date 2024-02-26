package com.datn.backend.system.admin.controller;

import com.datn.backend.entity.Bill;
import com.datn.backend.system.admin.model.request.CreateBillRequest;
import com.datn.backend.system.admin.service.BillServce;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BillController {

    @Autowired
    BillServce billServce;

    @GetMapping("/bills")
    public ResponseEntity<Object> getListBill(){
        List<Bill> bills = billServce.getListBill();
        return ResponseEntity.ok(bills);
    }

    @PostMapping("/bills/create")
    public ResponseEntity<Object> createBill(@Valid @RequestBody CreateBillRequest createBillRequest){
        Bill bills = billServce.CreateBill(createBillRequest);
        return ResponseEntity.ok(bills);
    }

    @PutMapping("/bills/update/{id}")
    public ResponseEntity<Object> update(@RequestBody CreateBillRequest createBillRequest, @PathVariable String id){
        Bill bills =billServce.updateDetailBill(createBillRequest, id);
        return ResponseEntity.ok(bills);
    }

    @DeleteMapping("/bills/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable String id){
        billServce.delete(id);
        return ResponseEntity.ok("Xóa thành công");
    }
}
