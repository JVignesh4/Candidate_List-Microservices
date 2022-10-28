package com.example.bank.model;
import com.example.bank.dto.BankAccountDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bank_details")
public class BankDetailsData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    private String bankName;
    private String ifsc;
    private String location;


    public BankDetailsData(BankAccountDTO bankAccountDTO) {
        this.bankName = bankAccountDTO.getBankName();
        this.ifsc = bankAccountDTO.getIfsc();
        this.location = bankAccountDTO.getLocation();
    }

    public BankDetailsData() {

    }

    public BankDetailsData(int userId, BankAccountDTO accountDTO) {
        this.userId=userId;
        this.bankName=accountDTO.getBankName();
        this.ifsc=accountDTO.getIfsc();
        this.location=accountDTO.getLocation();
    }
}

