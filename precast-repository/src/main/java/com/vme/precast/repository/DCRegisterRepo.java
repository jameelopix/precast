package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.DCRegister;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface DCRegisterRepo extends BaseRepo<DCRegister, Long> {
}
