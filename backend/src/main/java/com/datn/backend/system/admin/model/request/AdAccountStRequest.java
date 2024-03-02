package com.datn.backend.system.admin.model.request;

import com.datn.backend.config.constants.EntityProperties;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.Date;

@Getter
@Setter
public class AdAccountStRequest {

   private String citizenNumber;


   private String name;

   private String email;

   private Date dateOfBirth;

   private String numberPhone;

   private Boolean gender;

   private Integer role;

   private String avatar;

   private String password;


}
