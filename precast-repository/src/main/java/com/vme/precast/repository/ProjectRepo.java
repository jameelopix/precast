package com.vme.precast.repository;

import org.springframework.stereotype.Repository;

import com.vme.precast.domain.Project;

import coliseum.jpa.repo.BaseRepo;

@Repository
public interface ProjectRepo extends BaseRepo<Project, Long> {
}
