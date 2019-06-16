package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.CostCentre;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface CostCentreRepo extends BaseRepo<CostCentre, Long> {
}
