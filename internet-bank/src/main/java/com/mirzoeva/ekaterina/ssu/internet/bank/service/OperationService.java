package com.mirzoeva.ekaterina.ssu.internet.bank.service;

import com.mirzoeva.ekaterina.ssu.internet.bank.model.BankOperation;

/**
 * @author mirzoeva.ekaterina
 */
public interface OperationService {

    void commit(BankOperation operation);

    void rollback(BankOperation operation);
}
