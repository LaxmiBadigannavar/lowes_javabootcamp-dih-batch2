package com.lowes.bankingapp.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lowes.bankingapp.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}