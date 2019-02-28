package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.SteelItem;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface SteelItemRepo extends BaseRepo<SteelItem, Long> {
}
