package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.FinancialDetail;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface FinancialDetailRepo extends BaseRepo<FinancialDetail, Long> {
}
