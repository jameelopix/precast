package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.AccountDetails;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface AccountDetailsRepo extends BaseRepo<AccountDetails, Long> {
}
