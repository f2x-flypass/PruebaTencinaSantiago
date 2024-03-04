package com.test.santiago.financial.entity.infractructure.postgres.account;

import com.test.santiago.financial.entity.dto.AccountDto;
import com.test.santiago.financial.entity.dto.EnumDto;
import com.test.santiago.financial.entity.enums.EnumStatusAccount;
import com.test.santiago.financial.entity.infractructure.postgres.customer.Customer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="t_accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "s_accounts")
    @SequenceGenerator(name = "s_accounts", sequenceName = "s_accounts", allocationSize = 1)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name="account_type")
    private Long accountType;

    @Column(name="account_number")
    private Integer accountNumber;

    //@Enumerated
    @Column(name="state")
    private Long state;

    @Column(name="balance")
    private Integer balance;

    @Column(name="GMF")
    private Boolean gmf;

    @Column(name="creation_date")
    private Date creationDate;

    public AccountDto toDto(){
        return AccountDto.builder()
                .id(this.id)
                .accountType(this.accountType)
                .accountsNumber(this.accountNumber)
                //.state(EnumDto.builder().id(this.state.getId()).name(this.state.getName()).build())
                .state(this.state)
                .balance(this.balance)
                .gmf(this.gmf)
                .creationDate(this.creationDate)
                .build();

    }

    public static List<AccountDto> toDtoList(List<Account> accounts){
        return accounts.stream().map(Account::toDto).collect(Collectors.toList());
    }
}
