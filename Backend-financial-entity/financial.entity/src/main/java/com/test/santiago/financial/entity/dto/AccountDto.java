package com.test.santiago.financial.entity.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class AccountDto {
    private Long id;
    private Long accountType;
    private Integer accountsNumber;
    private EnumDto state;
    private Integer balance;
    private Boolean gmf;
    private Date creationDate;
}
