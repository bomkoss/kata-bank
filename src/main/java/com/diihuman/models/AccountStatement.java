package com.diihuman.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountStatement {
    private String accountNumber;
    private BigDecimal amount;
    private BigDecimal balance;
    private AccountOperation operation;
    private LocalDateTime cratedAt;

    public AccountStatement() {
    }

    public AccountStatement(String accountNumber, BigDecimal amount, BigDecimal balance, AccountOperation operation) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.balance = balance;
        this.operation = operation;
        this.cratedAt =  LocalDateTime.now();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountOperation getOperation() {
        return operation;
    }

    public void setOperation(AccountOperation operation) {
        this.operation = operation;
    }

    public LocalDateTime getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(LocalDateTime cratedAt) {
        this.cratedAt = cratedAt;
    }

    @Override
    public String toString() {
        return "AccountStatement{" +
                "accountNumber='" + accountNumber + '\'' +
                ", operation=" + operation +
                ", amount=" + amount +
                ", balance=" + balance +
                ", date=" + cratedAt +
                '}';
    }
}
