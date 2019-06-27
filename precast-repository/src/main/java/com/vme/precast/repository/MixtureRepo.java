package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.Mixture;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface MixtureRepo extends BaseRepo<Mixture, Long> {
}
