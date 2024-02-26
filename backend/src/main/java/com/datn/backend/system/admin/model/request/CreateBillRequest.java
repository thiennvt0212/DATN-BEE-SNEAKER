package com.datn.backend.system.admin.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CreateBillRequest {

    @JsonProperty("id")
    private String Id;

    @JsonProperty("code")
    private String Code;

    @JsonProperty("customerName")
    private String CustomerName;

    @Pattern(regexp="(09|03|07|08|05)+([0-9]{8})\\b", message = "Điện thoại không hợp lệ")
    @JsonProperty("phoneNumber")
    private String phone_number;

    @NotNull(message = "Địa chỉ trống")
    @NotEmpty(message = "Địa chỉ trống")
    @JsonProperty("address")
    private String Address;




}
