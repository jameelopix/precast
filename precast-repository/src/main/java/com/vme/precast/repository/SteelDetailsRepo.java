package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.SteelDetails;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface SteelDetailsRepo extends BaseRepo<SteelDetails, Long> {
}
