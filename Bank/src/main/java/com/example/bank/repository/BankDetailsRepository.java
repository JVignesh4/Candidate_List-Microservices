package com.example.bank.repository;
import com.example.bank.model.BankDetailsData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankDetailsRepository extends JpaRepository<BankDetailsData,Integer> {

}

