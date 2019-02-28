package com.vme.precast.element.api;

import java.util.Set;

import com.vme.precast.steelitem.api.SteelItemDTO;

import coliseum.service.BaseDTO;

public class ElementDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String code;

	private String type;

	private Long projectId;

	private Long mixtureId;

	private Set<Long> steelItemIds;

	private Set<SteelItemDTO> steelItemDTOs;

	private Double theoryQuantity;

	private Double weight;

	private Double length;

	private Double breadth;

	private Double theoryArea;

	private Double billingConcreteQuantity;

	public static String ID = "id";
	public static String NAME = "name";
	public static String CODE = "code";
	public static String TYPE = "type";
	public static String PROJECTID = "projectId";
	public static String MIXTUREID = "mixtureId";
	public static String THEORYQUANTITY = "theoryQuantity";
	public static String WEIGHT = "weight";
	public static String LENGTH = "length";
	public static String BREADTH = "breadth";
	public static String THEORYAREA = "theoryArea";
	public static String BILLINGCONCRETEQUANTITY = "billingConcreteQuantity";

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getMixtureId() {
		return mixtureId;
	}

	public void setMixtureId(Long mixtureId) {
		this.mixtureId = mixtureId;
	}

	public Double getTheoryQuantity() {
		return theoryQuantity;
	}

	public void setTheoryQuantity(Double theoryQuantity) {
		this.theoryQuantity = theoryQuantity;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getBreadth() {
		return breadth;
	}

	public void setBreadth(Double breadth) {
		this.breadth = breadth;
	}

	public Double getTheoryArea() {
		return theoryArea;
	}

	public void setTheoryArea(Double theoryArea) {
		this.theoryArea = theoryArea;
	}

	public Double getBillingConcreteQuantity() {
		return billingConcreteQuantity;
	}

	public void setBillingConcreteQuantity(Double billingConcreteQuantity) {
		this.billingConcreteQuantity = billingConcreteQuantity;
	}

	public Set<Long> getSteelItemIds() {
		return steelItemIds;
	}

	public void setSteelItemIds(Set<Long> steelItemIds) {
		this.steelItemIds = steelItemIds;
	}

	public Set<SteelItemDTO> getSteelItemDTOs() {
		return steelItemDTOs;
	}

	public void setSteelItemDTOs(Set<SteelItemDTO> steelItemDTOs) {
		this.steelItemDTOs = steelItemDTOs;
	}

}
