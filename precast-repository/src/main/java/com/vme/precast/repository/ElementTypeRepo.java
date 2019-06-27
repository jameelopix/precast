package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.ElementType;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ElementTypeRepo extends BaseRepo<ElementType, Long> {
}
