package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.PurchaseOrderItem;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface PurchaseOrderItemRepo extends BaseRepo<PurchaseOrderItem, Long> {
}
