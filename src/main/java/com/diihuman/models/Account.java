package com.diihuman.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {

    private String accountNumber;
    private String label;
    private BigDecimal balance;
    private LocalDateTime createdAt;

    public Account() {}

    public Account(String accountNumber, String label, BigDecimal balance) {
        this.accountNumber = accountNumber;
        this.label = label;
        this.balance = balance;
        this.createdAt = LocalDateTime.now();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
