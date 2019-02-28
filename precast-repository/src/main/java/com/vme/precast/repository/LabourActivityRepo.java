package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.LabourActivity;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface LabourActivityRepo extends BaseRepo<LabourActivity, Long> {
}
