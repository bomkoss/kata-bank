package com.diihuman.services;

import com.diihuman.datas.AbstractData;
import com.diihuman.models.Account;
import com.diihuman.models.AccountOperation;
import com.diihuman.models.AccountStatement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountStatementService {

    public void save(Account account, BigDecimal amount, AccountOperation operation) {
        List<AccountStatement> accountStatements = AbstractData.accountStatements.get(account.getAccountNumber());

        if(Objects.isNull(accountStatements)){
            AbstractData.accountStatements.put(
                    account.getAccountNumber(),
                    new ArrayList<>()
            );
            accountStatements = AbstractData.accountStatements.get(account.getAccountNumber());
        }

        accountStatements.add(new AccountStatement(
                account.getAccountNumber(),
                amount,
                account.getBalance(),
                operation
        ));
    }

    public void display(String accountNumber){
        AbstractData.accountStatements.get(accountNumber)
                .forEach(System.out::println);
    }
}
