package com.test.santiago.financial.entity.infractructure.postgres.account;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findAccountByAccountsNumber(Integer accountNumber);
    List<Account> findALLByCustomerIdOrderByStateAsc(Integer customerID);
}
