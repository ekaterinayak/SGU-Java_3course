package com.mirzoeva.ekaterina.ssu.internet.bank.repo;

import com.mirzoeva.ekaterina.ssu.internet.bank.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author mirzoeva.ekaterina
 */
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
