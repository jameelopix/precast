package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ProductionPlanItemDetail;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ProductionPlanItemDetailRepo extends BaseRepo<ProductionPlanItemDetail, Long> {
}
