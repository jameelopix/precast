package com.vme.precast.elementtype.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class ElementTypeSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<Long> projectIds;
	private List<String> names;

	public List<Long> getProjectIds() {
		return projectIds;
	}

	public List<String> getNames() {
		return names;
	}

	public void setProjectIds(List<Long> projectIds) {
		this.projectIds = projectIds;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
}
