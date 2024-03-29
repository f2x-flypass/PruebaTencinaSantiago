package com.test.santiago.financial.entity.rest;

import com.test.santiago.financial.entity.dto.CustomerDto;
import com.test.santiago.financial.entity.dto.ResponseErrorDto;
import com.test.santiago.financial.entity.service.CustomerService;
import com.test.santiago.financial.entity.utils.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer/" )

public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

    @PostMapping(value = "save")
    public ResponseEntity<Object> save(@RequestBody CustomerDto customerDto){
       try{
            return new ResponseEntity<>(customerService.saveCustomer(customerDto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(ResponseErrorDto.builder().code(e.getCode()).errorMessage(e.getMsg()).build(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping(value = "getAll")
    public ResponseEntity<List<CustomerDto>> getAll(){
       try{
            return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
