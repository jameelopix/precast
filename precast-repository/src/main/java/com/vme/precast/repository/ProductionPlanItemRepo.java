package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ProductionPlanItem;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ProductionPlanItemRepo extends BaseRepo<ProductionPlanItem, Long> {
}
