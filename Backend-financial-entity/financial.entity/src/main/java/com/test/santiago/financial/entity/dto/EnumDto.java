package com.test.santiago.financial.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class EnumDto {
    private Long id;
    private String name;
}
