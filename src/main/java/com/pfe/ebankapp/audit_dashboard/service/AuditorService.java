package com.pfe.ebankapp.audit_dashboard.service;

import com.pfe.ebankapp.account.dtos.AccountDTO;
import com.pfe.ebankapp.auth_users.dtos.UserDTO;
import com.pfe.ebankapp.transaction.dtos.TransactionDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AuditorService {

    Map<String, Long> getSystemTotals();

    Optional<UserDTO> findUserByEmail(String email);

    Optional<AccountDTO> findAccountDetailsByAccountNumber(String accountNumber);

    List<TransactionDTO> findTransactionsByAccountNumber(String accountNumber);

    Optional<TransactionDTO> findTransactionById(Long transactionId);
}
