package com.datn.backend.entity;

import com.datn.backend.config.constants.EntityProperties;
import com.datn.backend.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "product_detail")
public class ProductDetail extends PrimaryEntity {

    @Column
    private Integer quantity;

    @Column
    private BigDecimal price;

    @Column
    private Integer status;

    @Column(length = EntityProperties.LENGTH_ID)
    private String productId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String colorId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String brandId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String sizeId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String materialId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String shoesColarId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String soleId;

}
