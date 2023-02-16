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

        // create AccountStatementService and AccountService
        AccountStatementService accountStatementService = new AccountStatementService();
        AccountService accountService = new AccountService(accountStatementService);

        /*------------------------------------------------------------------------------*
        *                                  User Stories                                 *
        *-------------------------------------------------------------------------------*/

        // US_1 - Deposits
        accountService.deposit(accountNumber, new BigDecimal(500));
        accountService.deposit(accountNumber, new BigDecimal("100.75"));
        accountService.deposit(accountNumber, new BigDecimal("40.15"));

        // US_2 - Withdrawal
        accountService.withdraw(accountNumber, new BigDecimal("375.85"));
        accountService.withdraw(accountNumber, new BigDecimal("25.00"));

        // US_3 - Transactions history
        accountStatementService.display(accountNumber);
    }
}
