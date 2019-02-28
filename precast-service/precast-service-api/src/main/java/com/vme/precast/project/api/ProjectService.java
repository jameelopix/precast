package com.vme.precast.project.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ProjectService extends BaseService {

	@FlowDescriptor(flow = "createProject", request = "projectServiceRequest", response = "projectServiceResponse")
	public ProjectServiceResponse createProject(ProjectServiceRequest projectServiceRequest);

	@FlowDescriptor(flow = "getProjects", request = "projectServiceRequest", response = "projectServiceResponse")
	public ProjectServiceResponse getProjects(ProjectServiceRequest projectServiceRequest);

	@FlowDescriptor(flow = "updateProject", request = "projectServiceRequest", response = "projectServiceResponse")
	public ProjectServiceResponse updateProject(ProjectServiceRequest projectServiceRequest);

	@FlowDescriptor(flow = "deleteProject", request = "projectServiceRequest", response = "projectServiceResponse")
	public ProjectServiceResponse deleteProject(ProjectServiceRequest projectServiceRequest);

	@FlowDescriptor(flow = "estimateProject", request = "projectServiceRequest", response = "projectServiceResponse")
	public ProjectServiceResponse estimateProject(ProjectServiceRequest projectServiceRequest);
}