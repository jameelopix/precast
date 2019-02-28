package com.vme.precast.project.api;

import coliseum.service.ColiseumInterface;

public interface ProjectComponent extends ColiseumInterface {

	public ProjectServiceResponse createProject(ProjectServiceRequest projectServiceRequest);

	public ProjectServiceResponse getProjects(ProjectServiceRequest projectServiceRequest);

	public ProjectServiceResponse updateProject(ProjectServiceRequest projectServiceRequest);

	public ProjectServiceResponse deleteProject(ProjectServiceRequest projectServiceRequest);

	public ProjectServiceResponse estimateProject(ProjectServiceRequest projectServiceRequest);
}
