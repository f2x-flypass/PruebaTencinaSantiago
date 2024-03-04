package com.test.santiago.financial.entity.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CustomerDto {
    private Long id;
    private Long identificationType;
    private Long identificationNumber;
    private String name;
    private String lastname;
    private String mail;
    private Date birthDate;
    private Date creationDate;
}
