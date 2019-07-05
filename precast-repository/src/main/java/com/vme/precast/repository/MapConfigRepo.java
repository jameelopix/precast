package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.MapConfig;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface MapConfigRepo extends BaseRepo<MapConfig, Long> {
}
