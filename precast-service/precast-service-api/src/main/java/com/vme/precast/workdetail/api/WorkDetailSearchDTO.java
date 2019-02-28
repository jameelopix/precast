package com.vme.precast.workdetail.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class WorkDetailSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<Long> projectIds;

	private List<Long> elementTypeIds;

	private List<String> workNatures;

	private List<String> workDescs;

	public List<Long> getProjectIds() {
		return projectIds;
	}

	public List<Long> getElementTypeIds() {
		return elementTypeIds;
	}

	public List<String> getWorkNatures() {
		return workNatures;
	}

	public List<String> getWorkDescs() {
		return workDescs;
	}

	public void setProjectIds(List<Long> projectIds) {
		this.projectIds = projectIds;
	}

	public void setElementTypeIds(List<Long> elementTypeIds) {
		this.elementTypeIds = elementTypeIds;
	}

	public void setWorkNatures(List<String> workNatures) {
		this.workNatures = workNatures;
	}

	public void setWorkDescs(List<String> workDescs) {
		this.workDescs = workDescs;
	}
}