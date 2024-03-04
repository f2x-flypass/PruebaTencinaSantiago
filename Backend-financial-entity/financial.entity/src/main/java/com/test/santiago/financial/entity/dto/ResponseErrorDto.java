package com.test.santiago.financial.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
@Builder
public class ResponseErrorDto {
    private String code;
    private String errorMessage;
    private String userMessage;

}
