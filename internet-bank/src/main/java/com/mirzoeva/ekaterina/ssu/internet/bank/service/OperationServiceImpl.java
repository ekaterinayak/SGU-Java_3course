package com.mirzoeva.ekaterina.ssu.internet.bank.service;

import com.mirzoeva.ekaterina.ssu.internet.bank.exception.OperationException;
import com.mirzoeva.ekaterina.ssu.internet.bank.model.BankAccount;
import com.mirzoeva.ekaterina.ssu.internet.bank.model.BankOperation;
import com.mirzoeva.ekaterina.ssu.internet.bank.repo.BankAccountRepository;
import com.mirzoeva.ekaterina.ssu.internet.bank.repo.BankOperationRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author mirzoeva.ekaterina
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private BankOperationRepository bankOperationRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @SneakyThrows
    @Override
    public void commit(BankOperation operation) {
        BankAccount sender = operation.getSender();
        sender.setAmount(sender.getAmount() - operation.getAmount());
        if (sender.getAmount() < 0) {
            throw new OperationException("failed commit");
        }
        BankAccount receiver = operation.getReceiver();
        receiver.setAmount(receiver.getAmount() + operation.getAmount());
        bankAccountRepository.save(sender);
        bankAccountRepository.save(receiver);
        bankOperationRepository.save(operation);
    }

    @Override
    @SneakyThrows
    public void rollback(BankOperation operation) {
        BankAccount sender = operation.getSender();
        sender.setAmount(sender.getAmount() + operation.getAmount());
        BankAccount receiver = operation.getReceiver();
        receiver.setAmount(receiver.getAmount() - operation.getAmount());
        if (receiver.getAmount() < 0) {
            throw new OperationException("failed rollback");
        }
        operation.setReverse(true);
        bankAccountRepository.save(sender);
        bankAccountRepository.save(receiver);
        bankOperationRepository.save(operation);
    }
}
