package com.datn.backend.entity;

import com.datn.backend.config.constants.EntityProperties;
import com.datn.backend.entity.base.PrimaryEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Nationalized;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "image")
public class Image extends PrimaryEntity {

    @Column(length = Integer.MAX_VALUE)
    private String ulr;

    @Column(length = EntityProperties.LENGTH_ID)
    private String productDetailId;
}
