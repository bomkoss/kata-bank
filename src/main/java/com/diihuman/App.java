package com.diihuman;

import com.diihuman.datas.AbstractData;
import com.diihuman.models.Account;
import com.diihuman.services.AccountService;
import com.diihuman.services.AccountStatementService;

import java.math.BigDecimal;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        // Add a new account with 5500 units
        var accountNumber = "024512-001-96";
        AbstractData.accounts.put(accountNumber,
                new Account(accountNumber, "My scholar account", new BigDecimal(5500)));

        // AccountStatement
        AccountStatementService accountStatementService = new AccountStatementService();
        AccountService accountService = new AccountService(accountStatementService);

        // make a deposit of 500 Units
        accountService.deposit(accountNumber, new BigDecimal(500));
        accountService.deposit(accountNumber, new BigDecimal("100.75"));
        accountService.deposit(accountNumber, new BigDecimal("40.15"));

        // make a withdrawal of 6000 Units (account should be empty)
        accountService.withdraw(accountNumber, new BigDecimal("375.85"));
        accountService.withdraw(accountNumber, new BigDecimal("25.00"));

        // Display account's operations
        accountStatementService.display(accountNumber);
    }
}
