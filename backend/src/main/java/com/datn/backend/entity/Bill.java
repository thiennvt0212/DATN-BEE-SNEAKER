package com.datn.backend.entity;

import com.datn.backend.config.constants.EntityProperties;
import com.datn.backend.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "bill")
public class Bill extends PrimaryEntity {

    @Column(length = EntityProperties.LENGTH_ID)
    private String accountId;

    @Column(length = EntityProperties.LENGTH_CODE)
    @Nationalized
    private String code;

    @Column
    private Date comfirmationDate;

    @Column
    private Date deliveryDate;

    @Column
    private Date receivedDate;

    @Column
    private Date completionDate;

    @Column
    private Date desiredDate;

    @Column(length = EntityProperties.LENGTH_CODE)
    @Nationalized
    private String customerName;

    @Column(length = EntityProperties.LENGTH_DESCRIPTION)
    @Nationalized
    private String address;

    @Column(length = EntityProperties.LENGTH_PHONE)
    private String phoneNumber;

    @Column
    private BigDecimal totalMoney;

    @Column
    private BigDecimal reductionMoney;

    @Column
    private Integer status;

    @Column
    private Integer type;
}
