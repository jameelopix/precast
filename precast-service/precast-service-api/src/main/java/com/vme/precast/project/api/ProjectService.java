package com.vme.precast.project.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ProjectService extends BaseService {

 @FlowDescriptor(flow = "createproject", request = "projectServiceRequest", response = "projectServiceResponse")
 public ProjectServiceResponse createProject(ProjectServiceRequest projectServiceRequest);

 @FlowDescriptor(flow = "getprojects", request = "projectServiceRequest", response = "projectServiceResponse")
 public ProjectServiceResponse getProjects(ProjectServiceRequest projectServiceRequest);

 @FlowDescriptor(flow = "updateproject", request = "projectServiceRequest", response = "projectServiceResponse")
 public ProjectServiceResponse updateProject(ProjectServiceRequest projectServiceRequest);

 @FlowDescriptor(flow = "deleteproject", request = "projectServiceRequest", response = "projectServiceResponse")
 public ProjectServiceResponse deleteProject(ProjectServiceRequest projectServiceRequest);
}