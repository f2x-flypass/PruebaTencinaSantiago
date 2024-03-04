package com.test.santiago.financial.entity.service;


import com.test.santiago.financial.entity.dto.AccountDto;
import com.test.santiago.financial.entity.enums.EnumAccountType;
import com.test.santiago.financial.entity.enums.EnumStatusAccount;
import com.test.santiago.financial.entity.infractructure.postgres.account.Account;
import com.test.santiago.financial.entity.infractructure.postgres.account.AccountRepository;
import com.test.santiago.financial.entity.utils.Utils;
import com.test.santiago.financial.entity.utils.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class AccountService {
    private static AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountDto saveAccount(AccountDto accountDto) throws ValidationException  {
        if(accountDto.getAccountType() == EnumAccountType.SAVINGS.getId() || accountDto.getAccountType() == EnumAccountType.CURRENT.getId()) {
            if(accountDto.getBalance() < 0){
                throw new ValidationException("003", "No puede tener saldo negativo");
            }

            Account customer = Account.builder()
                    .accountNumber(getUniqueAccountNumber(accountDto))
                    .accountType(accountDto.getAccountType())
                    //.state((accountDto.getAccountType() == EnumAccountType.SAVINGS.getId() ? EnumStatusAccount.ACTIVE  :  EnumStatusAccount.findById(accountDto.getState())))
                    .state( EnumStatusAccount.ACTIVE.getId())
                    .balance(accountDto.getBalance())
                    .gmf(accountDto.getGmf())
                    .creationDate(new Date())
                    .build();
            return accountRepository.save(customer).toDto();
        } else {
            throw new ValidationException("002", "No es una cuenta valida");
        }
    }

    private static Integer getUniqueAccountNumber(AccountDto accountDto) {
        try {
            Integer randomNumber = Utils.getEightDigitsNumber();

            String accountNumberString = (accountDto.getAccountType() == EnumAccountType.SAVINGS.getId() ? EnumAccountType.SAVINGS.getInitialNumber().toString() + randomNumber : EnumAccountType.CURRENT.getInitialNumber().toString() + randomNumber);
            Integer accountNumber = Integer.parseInt(accountNumberString);


            Account account = accountRepository.findAccountByAccountNumber(accountNumber);

            if (Objects.isNull(account)) {
                return accountNumber;
            } else {
                return getUniqueAccountNumber(accountDto);
            }
        }catch (Exception e){
            return Utils.getEightDigitsNumber();
        }
    }

    public List<AccountDto> getAll(Integer customerId){
        return Account.toDtoList((List<Account>) accountRepository.findALLByCustomerIdOrderByStateAsc(customerId));
    }
}
