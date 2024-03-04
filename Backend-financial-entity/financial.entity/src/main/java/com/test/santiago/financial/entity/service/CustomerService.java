package com.test.santiago.financial.entity.service;


import com.test.santiago.financial.entity.dto.CustomerDto;
import com.test.santiago.financial.entity.infractructure.postgres.Customer.Customer;
import com.test.santiago.financial.entity.infractructure.postgres.Customer.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerDto saveCustomer(CustomerDto customerDto){
        Customer customer = Customer.builder()
                .identificationNumber(customerDto.getIdentificationNumber())
                .identificationType(customerDto.getIdentificationType())
                .name(customerDto.getName())
                .lastname(customerDto.getLastname())
                .mail(customerDto.getMail())
                .birthDate(customerDto.getBirthDate())
                .creationDate(new Date())

                .build();
        return customerRepository.save(customer).toDto();
    }

    public List<CustomerDto> getAllCustomer(){
        return Customer.toDtoList((List<Customer>) customerRepository.findAll());
    }
}
