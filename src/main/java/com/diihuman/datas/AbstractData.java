package com.diihuman.datas;

import com.diihuman.models.Account;
import com.diihuman.models.AccountStatement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractData {
    public static final Map<String, Account> accounts = new HashMap<>();
    public static final Map<String, List<AccountStatement>> accountStatements = new HashMap<>();
}
