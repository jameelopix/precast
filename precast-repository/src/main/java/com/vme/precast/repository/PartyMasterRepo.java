package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.PartyMaster;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface PartyMasterRepo extends BaseRepo<PartyMaster, Long> {
}
