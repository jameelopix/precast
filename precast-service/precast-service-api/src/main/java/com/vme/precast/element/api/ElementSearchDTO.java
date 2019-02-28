package com.vme.precast.element.api;

import java.util.List;

import coliseum.service.BaseSearchDTO;

public class ElementSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> names;

	private List<String> codes;

	private List<String> types;

	private List<Long> projectIds;

	private List<Long> mixtureIds;

	private List<Long> steelItemIds;

	private List<Double> theoryQuantitys;

	private List<Double> weights;

	private List<Double> lengths;

	private List<Double> breadths;

	private List<Double> theoryAreas;

	private List<Double> billingConcreteQuantitys;

	public List<String> getNames() {
		return names;
	}

	public List<String> getCodes() {
		return codes;
	}

	public List<String> getTypes() {
		return types;
	}

	public List<Long> getProjectIds() {
		return projectIds;
	}

	public List<Long> getMixtureIds() {
		return mixtureIds;
	}

	public List<Long> getSteelItemIds() {
		return steelItemIds;
	}

	public List<Double> getTheoryQuantitys() {
		return theoryQuantitys;
	}

	public List<Double> getWeights() {
		return weights;
	}

	public List<Double> getLengths() {
		return lengths;
	}

	public List<Double> getBreadths() {
		return breadths;
	}

	public List<Double> getTheoryAreas() {
		return theoryAreas;
	}

	public List<Double> getBillingConcreteQuantitys() {
		return billingConcreteQuantitys;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setCodes(List<String> codes) {
		this.codes = codes;
	}

	public void setTypes(List<String> types) {
		this.types = types;
	}

	public void setProjectIds(List<Long> projectIds) {
		this.projectIds = projectIds;
	}

	public void setMixtureIds(List<Long> mixtureIds) {
		this.mixtureIds = mixtureIds;
	}

	public void setSteelItemIds(List<Long> steelItemIds) {
		this.steelItemIds = steelItemIds;
	}

	public void setTheoryQuantitys(List<Double> theoryQuantitys) {
		this.theoryQuantitys = theoryQuantitys;
	}

	public void setWeights(List<Double> weights) {
		this.weights = weights;
	}

	public void setLengths(List<Double> lengths) {
		this.lengths = lengths;
	}

	public void setBreadths(List<Double> breadths) {
		this.breadths = breadths;
	}

	public void setTheoryAreas(List<Double> theoryAreas) {
		this.theoryAreas = theoryAreas;
	}

	public void setBillingConcreteQuantitys(List<Double> billingConcreteQuantitys) {
		this.billingConcreteQuantitys = billingConcreteQuantitys;
	}
}