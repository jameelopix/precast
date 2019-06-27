package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ItemBasicAmountDetails;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ItemBasicAmountDetailsRepo extends BaseRepo<ItemBasicAmountDetails, Long> {
}
