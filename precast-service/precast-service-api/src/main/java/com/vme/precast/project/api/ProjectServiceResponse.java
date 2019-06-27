package com.vme.precast.project.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class ProjectServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<ProjectDTO> projectDTOList;

 public List<ProjectDTO> getProjectDTOList() {
 return projectDTOList;
 }

 public void setProjectDTOList(List<ProjectDTO> projectDTOList) {
 this.projectDTOList = projectDTOList;
 }
}