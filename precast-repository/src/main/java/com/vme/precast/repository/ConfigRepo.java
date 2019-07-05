package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.Config;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ConfigRepo extends BaseRepo<Config, Long> {
}
