package com.diihuman;

import com.diihuman.datas.AbstractData;
import com.diihuman.exceptions.IllegalTransactionException;
import com.diihuman.exceptions.InconsistentAmount;
import com.diihuman.exceptions.ResourceNotFound;
import com.diihuman.models.Account;
import com.diihuman.services.AccountService;
import com.diihuman.services.AccountStatementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("AccountService specification")
public class AccountServiceTest {

    private AccountStatementService accountStatementService;
    private AccountService accountService;

    @BeforeEach
    void setup(){
        AbstractData.accounts.clear();
        accountStatementService = new AccountStatementService();
        accountService = new AccountService(accountStatementService);
    }

    @Test
    @DisplayName("Should not deposit when account not exist")
    void ShouldNotDepositWhenAccountNotExist(){
        // GIVEN
        // WHEN
        Exception exception = assertThrows(ResourceNotFound.class, () -> {
            accountService.deposit("000",  new BigDecimal(0) );
        });
        // THEN
        String expectedMessage = "Account 000 does not exist!";
        String actualMessage   = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should not deposit when amount is not consistent")
    void ShouldNotDepositWhenAmountIsNotConsistent(){
        // GIVEN
        AbstractData.accounts.put("000", new Account());
        // WHEN
        Exception exception = assertThrows(InconsistentAmount.class, () -> {
            accountService.deposit("000",  new BigDecimal(0) );
        });
        // THEN
        String expectedMessage = "Amount must be greater than zero!";
        String actualMessage   = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("should deposit with positive amount")
    void ShouldDepositWithPositiveAmount(){
        // GIVEN
        String accountName = "14G00445";
        Account account = new Account(accountName, "Mon Compte", new BigDecimal(350));
        AbstractData.accounts.put(accountName, account);
        // WHEN
        accountService.deposit(accountName, new BigDecimal(100));
        // THEN
        assertEquals( new BigDecimal(450), AbstractData.accounts.get(accountName).getBalance() );
    }

    @Test
    @DisplayName("Should not withdraw when balance is insufficient")
    void ShouldNotWithdrawWhenBalanceIsNotSufficient(){
        // GIVEN
        String accountNumber = "140";
        AbstractData.accounts.put(accountNumber, new Account(
                accountNumber,
                "Kelly account",
                new BigDecimal(999)
        ));
        // WHEN
        Exception exception = assertThrows(IllegalTransactionException.class, () -> {
            accountService.withdraw(accountNumber,  new BigDecimal(4000) );
        });
        // THEN
        String expectedMessage = "Insufficient balance!";
        String actualMessage   = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Should withdraw when balance is sufficient")
    void ShouldWithdrawWhenBalanceIsSufficient(){
        // GIVEN
        String accountNumber = "360-X20";
        AbstractData.accounts.put(accountNumber, new Account(
                accountNumber,
                "Kelly account 2",
                new BigDecimal(5000)
        ));
        // WHEN
        accountService.withdraw(accountNumber,  new BigDecimal(4000) );
        // THEN
        assertEquals(new BigDecimal(1000), AbstractData.accounts.get(accountNumber).getBalance());
    }
}