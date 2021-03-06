package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.Company;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface CompanyRepo extends BaseRepo<Company, Long> {
}
