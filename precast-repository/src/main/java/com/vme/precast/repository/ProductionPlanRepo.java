package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ProductionPlan;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ProductionPlanRepo extends BaseRepo<ProductionPlan, Long> {
}
