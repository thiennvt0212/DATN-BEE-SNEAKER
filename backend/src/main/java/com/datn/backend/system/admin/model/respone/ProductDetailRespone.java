package com.datn.backend.system.admin.model.respone;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.UUID;

public interface ProductDetailRespone {

    @Value("#{target.id}")
    String getId();

    @Value("#{target.quantity}")
    Integer getQuatity();

    @Value("#{target.price}")
    BigDecimal getPrice();

    @Value("#{target.descriptions}")
    String getDescriptions();

    @Value("#{target.status}")
    Integer getStatus();

    @Value("#{target.nameProduct}")
    String getNameProduct();

    @Value("#{target.nameColor}")
    String getNameColor();

    @Value("#{target.nameBrand}")
    String getNameBrand();

    @Value("#{target.nameSize}")
    String getNameSize();

    @Value("#{target.nameMaterial}")
    String getNameMaterial();

    @Value("#{target.nameShoeColar}")
    String getNameShoeColar();

    @Value("#{target.nameSole}")
    String getNameSole();

}
