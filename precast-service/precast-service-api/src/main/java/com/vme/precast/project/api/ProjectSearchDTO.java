package com.vme.precast.project.api;

import java.util.List;

import com.vme.precast.shared.UnitType;

import coliseum.service.BaseSearchDTO;

public class ProjectSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> codes;

	private List<String> names;

	private List<UnitType> unitTypes;

	private List<Double> quantities;

	private List<Double> productionRates;
	private List<Double> productionAmounts;

	private List<Double> logisticsRates;
	private List<Double> logisticsAmounts;

	private List<Double> erectionRates;
	private List<Double> erectionAmounts;

	private List<Double> miscAmounts;
	private List<Double> totalAmounts;

	public List<String> getCodes() {
		return codes;
	}

	public List<String> getNames() {
		return names;
	}

	public List<UnitType> getUnitTypes() {
		return unitTypes;
	}

	public List<Double> getQuantities() {
		return quantities;
	}

	public List<Double> getProductionRates() {
		return productionRates;
	}

	public List<Double> getProductionAmounts() {
		return productionAmounts;
	}

	public List<Double> getLogisticsRates() {
		return logisticsRates;
	}

	public List<Double> getLogisticsAmounts() {
		return logisticsAmounts;
	}

	public List<Double> getErectionRates() {
		return erectionRates;
	}

	public List<Double> getErectionAmounts() {
		return erectionAmounts;
	}

	public List<Double> getMiscAmounts() {
		return miscAmounts;
	}

	public List<Double> getTotalAmounts() {
		return totalAmounts;
	}

	public void setCodes(List<String> codes) {
		this.codes = codes;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public void setUnitTypes(List<UnitType> unitTypes) {
		this.unitTypes = unitTypes;
	}

	public void setQuantities(List<Double> quantities) {
		this.quantities = quantities;
	}

	public void setProductionRates(List<Double> productionRates) {
		this.productionRates = productionRates;
	}

	public void setProductionAmounts(List<Double> productionAmounts) {
		this.productionAmounts = productionAmounts;
	}

	public void setLogisticsRates(List<Double> logisticsRates) {
		this.logisticsRates = logisticsRates;
	}

	public void setLogisticsAmounts(List<Double> logisticsAmounts) {
		this.logisticsAmounts = logisticsAmounts;
	}

	public void setErectionRates(List<Double> erectionRates) {
		this.erectionRates = erectionRates;
	}

	public void setErectionAmounts(List<Double> erectionAmounts) {
		this.erectionAmounts = erectionAmounts;
	}

	public void setMiscAmounts(List<Double> miscAmounts) {
		this.miscAmounts = miscAmounts;
	}

	public void setTotalAmounts(List<Double> totalAmounts) {
		this.totalAmounts = totalAmounts;
	}
}
