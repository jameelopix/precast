package com.vme.precast.project.controller;

import java.util.List;

import com.vme.precast.project.api.ProjectDTO;
import com.vme.precast.project.api.ProjectSearchDTO;

import coliseum.web.BaseClientModel;

public class ProjectClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private ProjectDTO projectDTO;

 private ProjectSearchDTO projectSearchDTO;

 private List<ProjectDTO> projectDTOList;

 public ProjectDTO getProjectDTO() {
 return projectDTO;
 }

 public void setProjectDTO(ProjectDTO projectDTO) {
 this.projectDTO = projectDTO;
 }

 public List<ProjectDTO> getProjectDTOList() {
 return projectDTOList;
 }

 public void setProjectDTOList(List<ProjectDTO> projectDTOList) {
 this.projectDTOList = projectDTOList;
 }

 public ProjectSearchDTO getProjectSearchDTO() {
 return projectSearchDTO;
 }

 public void setProjectSearchDTO(ProjectSearchDTO projectSearchDTO) {
 this.projectSearchDTO = projectSearchDTO;
 }

}