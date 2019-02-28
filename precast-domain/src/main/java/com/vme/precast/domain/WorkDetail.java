package com.vme.precast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class WorkDetail extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(insertable = false, updatable = false, name = "project_id")
	private Long projectId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@Column(insertable = false, updatable = false, name = "elementType_id")
	private Long elementTypeId;

	@ManyToOne(fetch = FetchType.LAZY)
	private ElementType elementType;

	private String workNature;

	private String workDesc;

	public Long getId() {
		return id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public Project getProject() {
		return project;
	}

	public Long getElementTypeId() {
		return elementTypeId;
	}

	public ElementType getElementType() {
		return elementType;
	}

	public String getWorkNature() {
		return workNature;
	}

	public String getWorkDesc() {
		return workDesc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setElementTypeId(Long elementTypeId) {
		this.elementTypeId = elementTypeId;
	}

	public void setElementType(ElementType elementType) {
		this.elementType = elementType;
	}

	public void setWorkNature(String workNature) {
		this.workNature = workNature;
	}

	public void setWorkDesc(String workDesc) {
		this.workDesc = workDesc;
	}
}