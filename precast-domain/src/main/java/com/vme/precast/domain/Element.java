package com.vme.precast.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class Element extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String code;

	private String type;

	@Column(insertable = false, updatable = false, name = "project_id")
	private Long projectId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Project project;

	@Column(insertable = false, updatable = false, name = "mixture_id")
	private Long mixtureId;

	@ManyToOne(fetch = FetchType.LAZY)
	private Mixture mixture;

	@OneToMany(mappedBy = "element", fetch = FetchType.LAZY)
	private List<SteelItem> steelItems;

	private Double theoryQuantity;

	private Double weight;

	private Double length;

	private Double breadth;

	private Double theoryArea;

	private Double billingConcreteQuantity;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public String getType() {
		return type;
	}

	public Long getProjectId() {
		return projectId;
	}

	public Project getProject() {
		return project;
	}

	public Long getMixtureId() {
		return mixtureId;
	}

	public Mixture getMixture() {
		return mixture;
	}

	public List<SteelItem> getSteelItems() {
		return steelItems;
	}

	public Double getTheoryQuantity() {
		return theoryQuantity;
	}

	public Double getWeight() {
		return weight;
	}

	public Double getLength() {
		return length;
	}

	public Double getBreadth() {
		return breadth;
	}

	public Double getTheoryArea() {
		return theoryArea;
	}

	public Double getBillingConcreteQuantity() {
		return billingConcreteQuantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setMixtureId(Long mixtureId) {
		this.mixtureId = mixtureId;
	}

	public void setMixture(Mixture mixture) {
		this.mixture = mixture;
	}

	public void setSteelItems(List<SteelItem> steelItems) {
		this.steelItems = steelItems;
	}

	public void setTheoryQuantity(Double theoryQuantity) {
		this.theoryQuantity = theoryQuantity;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public void setBreadth(Double breadth) {
		this.breadth = breadth;
	}

	public void setTheoryArea(Double theoryArea) {
		this.theoryArea = theoryArea;
	}

	public void setBillingConcreteQuantity(Double billingConcreteQuantity) {
		this.billingConcreteQuantity = billingConcreteQuantity;
	}
}