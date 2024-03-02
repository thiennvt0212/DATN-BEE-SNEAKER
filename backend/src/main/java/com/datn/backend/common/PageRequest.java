package com.datn.backend.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class PageRequest {
    private int page = 0;
    private int size = 10;
}
