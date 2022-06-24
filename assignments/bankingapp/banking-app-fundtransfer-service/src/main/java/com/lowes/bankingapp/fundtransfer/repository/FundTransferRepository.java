package com.lowes.bankingapp.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.bankingapp.fundtransfer.model.FundTransfer;

public interface FundTransferRepository extends JpaRepository<FundTransfer, Integer>{

}
