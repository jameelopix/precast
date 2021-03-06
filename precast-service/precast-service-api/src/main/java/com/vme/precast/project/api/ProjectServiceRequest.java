package com.vme.precast.project.api;

import coliseum.service.BaseServiceRequest;

public class ProjectServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private ProjectDTO projectDTO;

 private ProjectSearchDTO projectSearchDTO;

 public ProjectDTO getProjectDTO() {
 return projectDTO;
 }

 public void setProjectDTO(ProjectDTO projectDTO) {
 this.projectDTO = projectDTO;
 }

 public ProjectSearchDTO getProjectSearchDTO() {
 return projectSearchDTO;
 }

 public void setProjectSearchDTO(ProjectSearchDTO projectSearchDTO) {
 this.projectSearchDTO = projectSearchDTO;
 }
}
