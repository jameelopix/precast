package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.Vendor;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface VendorRepo extends BaseRepo<Vendor, Long> {
}
