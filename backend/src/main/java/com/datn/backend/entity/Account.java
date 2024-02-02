package com.datn.backend.entity;

import com.datn.backend.config.constants.EntityProperties;
import com.datn.backend.entity.base.PrimaryEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "account")
public class Account extends PrimaryEntity {

    @Column(length = EntityProperties.LENGTH_CODE)
    private String citizenNumber;

    @Column(length = EntityProperties.LENGTH_NAME)
    @Nationalized
    private String name;

    @Column(length = EntityProperties.LENGTH_EMAIL)
    private String email;

    @Column
    private Date dateOfBirth;

    @Column(length = EntityProperties.LENGTH_PHONE)
    private String numberPhone;

    @Column
    private Boolean gender;

    @Column
    private Integer role;

    @Column(length = Integer.MAX_VALUE)
    private String avatar;

    @Column(length = EntityProperties.LENGTH_PASSWORD)
    private String password;

}
