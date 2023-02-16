package com.diihuman.services;

import com.diihuman.datas.AbstractData;
import com.diihuman.exceptions.IllegalTransactionException;
import com.diihuman.exceptions.InconsistentAmount;
import com.diihuman.exceptions.ResourceNotFound;
import com.diihuman.models.Account;
import com.diihuman.models.AccountOperation;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountService {

    private final AccountStatementService accountStatementService;

    public AccountService(AccountStatementService accountStatementService) {
        this.accountStatementService = accountStatementService;
    }


    public void deposit(String accountNumber, BigDecimal amount){
        Account account = getAccountAndVerifyAmount(accountNumber, amount);

        accountStatementService.save(account, amount, AccountOperation.DEPOSIT);
        account.setBalance( account.getBalance().add(amount) );
    }


    public void withdraw(String accountNumber, BigDecimal amount){
        Account account = getAccountAndVerifyAmount(accountNumber, amount);

        if (amount.compareTo(account.getBalance()) > 0)
            throw new IllegalTransactionException("Insufficient balance!");

        accountStatementService.save(account, amount, AccountOperation.WITHDRAWAL);
        account.setBalance( account.getBalance().subtract(amount) );
    }


    private static Account getAccountAndVerifyAmount(String accountNumber, BigDecimal amount) {
        Account account = AbstractData.accounts.get(accountNumber);

        if(Objects.isNull(account))
            throw new ResourceNotFound( String.format("Account %s does not exist!", accountNumber) );

        if (amount.compareTo(new BigDecimal(0)) <= 0)
            throw new InconsistentAmount("Amount must be greater than zero!");
        return account;
    }
}
