package com.diihuman;

import com.diihuman.datas.AbstractData;
import com.diihuman.models.Account;
import com.diihuman.models.AccountOperation;
import com.diihuman.models.AccountStatement;
import com.diihuman.services.AccountService;
import com.diihuman.services.AccountStatementService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AccountStatementServiceTest {

    @AfterEach
    void tearDown(){
        AbstractData.accountStatements.clear();
    }

    @Test
    @DisplayName("Should create new statement for deposit operation")
    public void ShouldCreateNewStatementForDepositOperation(){
        // GIVEN
        AccountStatementService accountStatementService = new AccountStatementService();
        Account account = new Account("000", "Mon Compte", new BigDecimal(850));
        AbstractData.accountStatements.put(account.getAccountNumber(), new ArrayList<>());
        // WHEN
        accountStatementService.save(account, new BigDecimal(100), AccountOperation.DEPOSIT);
        // THEN
        int size = AbstractData.accountStatements.get(account.getAccountNumber()).size();
        assertEquals(1, size);
    }



}
