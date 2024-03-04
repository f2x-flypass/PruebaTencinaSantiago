package com.test.santiago.financial.entity.infractructure.postgres.Customer;

import com.test.santiago.financial.entity.dto.CustomerDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="t_customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_CUSTOMER")
    @SequenceGenerator(name = "S_CUSTOMER", sequenceName = "S_CUSTOMER", allocationSize = 1)
    @Column(name="id")
    private Long id;

    @Column(name="identification_type")
    private Long identificationType;

    @Column(name="identification_number")
    private Long identificationNumber;

    @Column(name="name")
    private String name;

    @Column(name="lastname")
    private String lastname;

    @Column(name="mail")
    private String mail;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="creation_date")
    private Date creationDate;

    public CustomerDto toDto(){
        return CustomerDto.builder()
                .id(this.id)
                .identificationType(this.identificationType)
                .identificationNumber(this.identificationNumber)
                .name(this.name)
                .lastname(this.lastname)
                .mail(this.mail)
                .birthDate(this.birthDate)
                .creationDate(this.creationDate)
                .build();

    }

    public static List<CustomerDto> toDtoList(List<Customer> customers){
        return customers.stream().map(Customer::toDto).collect(Collectors.toList());
    }
}
