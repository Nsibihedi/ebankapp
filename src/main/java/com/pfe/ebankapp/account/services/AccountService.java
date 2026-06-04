package com.pfe.ebankapp.account.services;


import com.pfe.ebankapp.account.dtos.AccountDTO;
import com.pfe.ebankapp.account.entity.Account;
import com.pfe.ebankapp.auth_users.entity.User;
import com.pfe.ebankapp.enums.AccountType;
import com.pfe.ebankapp.res.Response;

import java.util.List;

public interface AccountService {
    Account createAccount(AccountType accountType, User user);

    Response<List<AccountDTO>> getMyAccounts();

    Response<?> closeAccount(String accountNumber);
}
