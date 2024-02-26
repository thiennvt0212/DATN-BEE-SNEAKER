package com.datn.backend.system.admin.service.impl;

import com.datn.backend.entity.Bill;
import com.datn.backend.system.admin.model.request.CreateBillRequest;
import com.datn.backend.system.admin.repository.AdBillRepository;
import com.datn.backend.system.admin.service.BillServce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillServiceImpl implements BillServce {
    @Autowired
    private AdBillRepository adBillRepository;


    @Override
    public List<Bill> getListBill() {
        return adBillRepository.findAll();
    }

    @Override
    public Bill CreateBill(CreateBillRequest createBillRequest) {
        Bill bill = new Bill();
        bill.setId(createBillRequest.getId());
        bill.setCode(createBillRequest.getCode());
        bill.setPhoneNumber(createBillRequest.getPhone_number());
        bill.setCustomerName(createBillRequest.getCustomerName());
        bill.setAddress(createBillRequest.getAddress());
         adBillRepository.save(bill);
         return bill;

    }

    @Override
    public Bill updateDetailBill(CreateBillRequest createBillRequest, String id){
        Optional<Bill> rs = adBillRepository.findById(id);
        if (rs.isEmpty()) {
            System.out.println("Đơn hàng không tồn tại");
        }
        Bill bill = rs.get();
        bill.setCode(createBillRequest.getCode());
        bill.setPhoneNumber(createBillRequest.getPhone_number());
        bill.setCustomerName(createBillRequest.getCustomerName());
        bill.setAddress(createBillRequest.getAddress());
        return  adBillRepository.save(bill);
    }

    @Override
    public String delete(String id) {
         adBillRepository.deleteById(id);
        return id;
    }

    @Override
    public Bill findBillById(String id) {
        Optional<Bill> billOptional = adBillRepository.findById(id);
        if (billOptional.isEmpty()) {
            System.out.println("Đơn hàng không tồn tại");
        }
        return billOptional.get();
    }

}
