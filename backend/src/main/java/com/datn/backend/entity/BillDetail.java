package com.datn.backend.entity;

import com.datn.backend.config.constants.EntityProperties;
import com.datn.backend.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bill_detail")
public class BillDetail extends PrimaryEntity {

    @Column(length = EntityProperties.LENGTH_ID)
    private String billId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String productDetailId;

    @Column
    private Integer quantity;

    @Column
    private BigDecimal price;

    @Column
    private Integer status;
}
