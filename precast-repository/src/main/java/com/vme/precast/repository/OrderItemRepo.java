package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.OrderItem;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface OrderItemRepo extends BaseRepo<OrderItem, Long> {
}
