package com.datn.backend.system.admin.service;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Brand;
import com.datn.backend.system.admin.model.request.AdAccountStRequest;
import com.datn.backend.system.admin.model.request.AdBrandRequest;

import java.util.List;

public interface AdAcountService {

        List<Account> getAll();

       List<Account> findAllByGender(boolean isMale, boolean isFemale);

        Account add(AdAccountStRequest adAccountStRequest);

        Account update(String id, AdAccountStRequest adAccountStRequest);

        String delete(String id);

        Account findById(String id);



    }


