package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.MixtureItem;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface MixtureItemRepo extends BaseRepo<MixtureItem, Long> {
}
