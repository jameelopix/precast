package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.WorkDetail;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface WorkDetailRepo extends BaseRepo<WorkDetail, Long> {
}
