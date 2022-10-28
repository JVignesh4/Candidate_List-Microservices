package com.example.bank.service;

import com.example.bank.dto.BankAccountDTO;
import com.example.bank.model.BankDetailsData;

public interface IBankDetailsService {

    BankDetailsData updateBankDetails(int userId, BankAccountDTO accountDTO);

    String addBankDetails(BankAccountDTO bankAccountDTO);

    BankDetailsData viewBankDetails(String token);
    void deleteBankDetails(int id);
}

