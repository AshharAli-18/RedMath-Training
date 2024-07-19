package com.Training.BankingApp.transfer;

import com.Training.BankingApp.account.Account;
import com.Training.BankingApp.transaction.Transaction;
import com.Training.BankingApp.account.AccountRepository;
import com.Training.BankingApp.transaction.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TransferService {
    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Transactional
    public void transfer(Long fromAccountId, String toAccountNumber, long amount) {
        Account fromAccount = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new RuntimeException("From account not found"));
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);
        if (toAccount == null) {
            throw new RuntimeException("To account not found");
        }

        if (fromAccount.getBalance() < 0) {
            throw new RuntimeException("Insufficient balance");
        }
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        toAccount.setBalance(toAccount.getBalance()+amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        Transaction transaction = new Transaction();
        transaction.setTransactionId(System.currentTimeMillis());
        transaction.setAccountId(fromAccountId);
        transaction.setAmount(amount);
        transaction.setDate(LocalDate.now());

        transactionRepository.save(transaction);

        Transfer transfer = new Transfer();
        transfer.setFromAccountId(fromAccountId);
        transfer.setToAccountNumber(toAccountNumber);
        transfer.setAmount(amount);
        transfer.setTransactionId(transaction.getTransactionId());

        transferRepository.save(transfer);
    }
}