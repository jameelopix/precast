package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.Item;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ItemRepo extends BaseRepo<Item, Long> {
}
