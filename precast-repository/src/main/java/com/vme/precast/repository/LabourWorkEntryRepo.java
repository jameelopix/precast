package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.LabourWorkEntry;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface LabourWorkEntryRepo extends BaseRepo<LabourWorkEntry, Long> {
}
