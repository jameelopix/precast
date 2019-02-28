package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.BankAccount;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface BankAccountRepo extends BaseRepo<BankAccount, Long> {
}
