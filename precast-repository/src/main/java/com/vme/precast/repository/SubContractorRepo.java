package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.SubContractor;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface SubContractorRepo extends BaseRepo<SubContractor, Long> {
}
