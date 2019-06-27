package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.RawMaterial;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface RawMaterialRepo extends BaseRepo<RawMaterial, Long> {
}
