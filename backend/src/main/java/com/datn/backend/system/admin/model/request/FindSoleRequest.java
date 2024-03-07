package com.datn.backend.system.admin.model.request;

import com.datn.backend.common.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindSoleRequest extends PageRequest {
      private String value;
}
