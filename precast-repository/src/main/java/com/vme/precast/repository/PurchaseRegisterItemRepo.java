package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.PurchaseRegisterItem;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface PurchaseRegisterItemRepo extends BaseRepo<PurchaseRegisterItem, Long> {
}
