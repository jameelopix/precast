package com.vme.precast.project.api;

import com.vme.precast.shared.UnitType;

import coliseum.service.BaseDTO;

public class ProjectDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String code;

	private String name;

	private UnitType unitType;

	private Double quantity;

	private Double productionRate;
	private Double productionAmount;

	private Double logisticsRate;
	private Double logisticsAmount;

	private Double erectionRate;
	private Double erectionAmount;

	private Double miscAmount;
	private Double totalAmount;

	public static String ID = "id";
	public static String CODE = "code";
	public static String NAME = "name";
	public static String UNITTYPE = "unitType";
	public static String QUANTITY = "quantity";
	public static String PRODUCTIONRATE = "productionRate";
	public static String PRODUCTIONAMOUNT = "productionAmount";
	public static String LOGISTICSRATE = "logisticsRate";
	public static String LOGISTICSAMOUNT = "logisticsAmount";
	public static String ERECTIONRATE = "erectionRate";
	public static String ERECTIONAMOUNT = "erectionAmount";
	public static String MISCAMOUNT = "miscAmount";
	public static String TOTALAMOUNT = "totalAmount";

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public Double getQuantity() {
		return quantity;
	}

	public Double getProductionRate() {
		return productionRate;
	}

	public Double getProductionAmount() {
		return productionAmount;
	}

	public Double getLogisticsRate() {
		return logisticsRate;
	}

	public Double getLogisticsAmount() {
		return logisticsAmount;
	}

	public Double getErectionRate() {
		return erectionRate;
	}

	public Double getErectionAmount() {
		return erectionAmount;
	}

	public Double getMiscAmount() {
		return miscAmount;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setProductionRate(Double productionRate) {
		this.productionRate = productionRate;
	}

	public void setProductionAmount(Double productionAmount) {
		this.productionAmount = productionAmount;
	}

	public void setLogisticsRate(Double logisticsRate) {
		this.logisticsRate = logisticsRate;
	}

	public void setLogisticsAmount(Double logisticsAmount) {
		this.logisticsAmount = logisticsAmount;
	}

	public void setErectionRate(Double erectionRate) {
		this.erectionRate = erectionRate;
	}

	public void setErectionAmount(Double erectionAmount) {
		this.erectionAmount = erectionAmount;
	}

	public void setMiscAmount(Double miscAmount) {
		this.miscAmount = miscAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
}
