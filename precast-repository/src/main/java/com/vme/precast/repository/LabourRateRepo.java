package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.LabourRate;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface LabourRateRepo extends BaseRepo<LabourRate, Long> {
}
