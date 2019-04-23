package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.Address;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface AddressRepo extends BaseRepo<Address, Long> {
}
