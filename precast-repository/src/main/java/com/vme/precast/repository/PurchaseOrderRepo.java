package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.PurchaseOrder;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface PurchaseOrderRepo extends BaseRepo<PurchaseOrder, Long> {
}
