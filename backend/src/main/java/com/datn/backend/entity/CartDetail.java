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
@Table(name = "cart_detail")
public class CartDetail extends PrimaryEntity {

    @Column(length = EntityProperties.LENGTH_ID)
    private String productDetailId;

    @Column(length = EntityProperties.LENGTH_ID)
    private String cartId;

    @Column
    private Integer quantity;
}
