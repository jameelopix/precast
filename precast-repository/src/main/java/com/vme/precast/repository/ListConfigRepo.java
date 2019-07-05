package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ListConfig;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ListConfigRepo extends BaseRepo<ListConfig, Long> {
}
