package com.vme.precast.project.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.project.api.ProjectServiceRequest;
import com.vme.precast.project.api.ProjectValidator;
import com.vme.precast.repository.ProjectRepo;

import coliseum.service.ErrorDTO;

public class ProjectValidatorImpl implements ProjectValidator {
 @Autowired
 ProjectRepo projectRepo;

 @Override
 public ErrorDTO checkProjectDuplicate(ProjectServiceRequest projectServiceRequest) {
 return null;
 }
}