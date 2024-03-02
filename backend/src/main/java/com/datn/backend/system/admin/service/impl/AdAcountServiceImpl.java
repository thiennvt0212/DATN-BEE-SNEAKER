package com.datn.backend.system.admin.service.impl;

import com.datn.backend.entity.Account;
import com.datn.backend.entity.Color;
import com.datn.backend.system.admin.model.request.AdAccountStRequest;
import com.datn.backend.system.admin.model.request.AdColorRequest;
import com.datn.backend.system.admin.repository.AdAccountRepository;
import com.datn.backend.system.admin.repository.AdcolorRepository;
import com.datn.backend.system.admin.service.AdAcountService;
import com.datn.backend.system.admin.service.AdColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdAcountServiceImpl implements AdAcountService {

    @Autowired
    private AdAccountRepository adAccountRepository;


    @Override
    public List<Account> getAll() {
        return adAccountRepository.findAllRoleTwo();
    }

    public List<Account> findAllByGender(boolean isMale, boolean isFemale) {
        return adAccountRepository.findAllByGender(isMale, isFemale);
    }

    @Override
    public Account add(AdAccountStRequest adAccountStRequest) {
        Account account = new Account();
        account.setCitizenNumber(adAccountStRequest.getCitizenNumber());
        account.setName(adAccountStRequest.getName());
        account.setEmail(adAccountStRequest.getEmail());
        account.setDateOfBirth(adAccountStRequest.getDateOfBirth());
        account.setNumberPhone(adAccountStRequest.getNumberPhone());
        account.setGender(adAccountStRequest.getGender());
        account.setAvatar(adAccountStRequest.getAvatar());
        account.setPassword(adAccountStRequest.getPassword());
        return adAccountRepository.save(account);

    }

    @Override
    public Account update(String id, AdAccountStRequest adAccountStRequest) {
        Account account = adAccountRepository.findById(id).get();
        if(account != null){
            account.setCitizenNumber(adAccountStRequest.getCitizenNumber());
            account.setName(adAccountStRequest.getName());
            account.setEmail(adAccountStRequest.getEmail());
            account.setDateOfBirth(adAccountStRequest.getDateOfBirth());
            account.setNumberPhone(adAccountStRequest.getNumberPhone());
            account.setGender(adAccountStRequest.getGender());
            account.setAvatar(adAccountStRequest.getAvatar());
            account.setPassword(adAccountStRequest.getPassword());
        }
        return adAccountRepository.save(account);    }



    @Override
    public String delete(String id) {
        adAccountRepository.deleteById(id);
        return id;
    }

    @Override
    public Account findById(String id) {
        Account account = adAccountRepository.findById(id).get();
        return account;
    }

}
