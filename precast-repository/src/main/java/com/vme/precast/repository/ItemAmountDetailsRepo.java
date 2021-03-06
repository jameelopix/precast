package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ItemAmountDetails;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ItemAmountDetailsRepo extends BaseRepo<ItemAmountDetails, Long> {
}
