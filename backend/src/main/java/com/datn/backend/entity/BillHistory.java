package com.datn.backend.entity;

import com.datn.backend.config.constants.EntityProperties;
import com.datn.backend.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bill_history")
public class BillHistory extends PrimaryEntity {

    @Column(length = EntityProperties.LENGTH_ID)
    private String billId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String accountId;

    @Column
    private Integer statusBill;
}
