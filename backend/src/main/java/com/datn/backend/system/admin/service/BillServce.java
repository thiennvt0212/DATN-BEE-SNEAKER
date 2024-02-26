package com.datn.backend.system.admin.service;

import com.datn.backend.entity.Bill;
import com.datn.backend.system.admin.model.request.CreateBillRequest;

import java.util.List;

public interface BillServce {

    List<Bill> getListBill();

    Bill CreateBill(CreateBillRequest createBillRequest);

    Bill updateDetailBill(CreateBillRequest createBillRequest, String id);

    String delete(String id);

    Bill findBillById(String id);

}
