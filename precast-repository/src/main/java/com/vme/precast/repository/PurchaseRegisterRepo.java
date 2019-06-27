package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.PurchaseRegister;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface PurchaseRegisterRepo extends BaseRepo<PurchaseRegister, Long> {
}
