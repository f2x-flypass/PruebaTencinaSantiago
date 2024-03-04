package com.test.santiago.financial.entity.rest;

import com.test.santiago.financial.entity.dto.AccountDto;
import com.test.santiago.financial.entity.dto.CustomerDto;
import com.test.santiago.financial.entity.dto.ResponseErrorDto;
import com.test.santiago.financial.entity.service.AccountService;
import com.test.santiago.financial.entity.utils.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account/" )

public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;

    }

    @PostMapping(value = "save")
    public ResponseEntity<Object> save(@RequestBody AccountDto accountDto){
       try{
            return new ResponseEntity<>(accountService.saveAccount(accountDto), HttpStatus.OK);
        } catch (ValidationException e) {
            return new ResponseEntity<>(ResponseErrorDto.builder().code(e.getCode()).errorMessage(e.getMsg()).build(), HttpStatus.CONFLICT);
        }
    }
    @GetMapping(value = "getAll/{customerId}")
    public ResponseEntity<List<AccountDto>> getAll(@PathVariable Integer customerId){
       try{
            return new ResponseEntity<>(accountService.getAll(customerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }
}
