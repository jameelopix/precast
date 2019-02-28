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
public class ElementType extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(insertable = false, updatable = false, name = "project_id")
	private Long projectId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	private String name;

	public Long getId() {
		return id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public Project getProject() {
		return project;
	}

	public String getName() {
		return name;
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

	public void setName(String name) {
		this.name = name;
	}

}