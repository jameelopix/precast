package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.CashTransfer;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface CashTransferRepo extends BaseRepo<CashTransfer, Long> {
}
