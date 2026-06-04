package com.pfe.ebankapp.transaction.services;

import com.pfe.ebankapp.res.Response;
import com.pfe.ebankapp.transaction.dtos.TransactionDTO;
import com.pfe.ebankapp.transaction.dtos.TransactionRequest;

import java.util.List;

public interface TransactionService {
    Response<?>createTransaction(TransactionRequest transactionRequest);
    Response<List<TransactionDTO>> getTransactionsForMyAccount(String accountNumber, int page, int size);
}
