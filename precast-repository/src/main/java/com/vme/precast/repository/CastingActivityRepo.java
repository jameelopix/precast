package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.CastingActivity;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface CastingActivityRepo extends BaseRepo<CastingActivity, Long> {
}
