package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ElementDetails;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ElementDetailsRepo extends BaseRepo<ElementDetails, Long> {
}
