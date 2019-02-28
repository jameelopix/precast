package com.vme.precast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vme.precast.shared.UnitType;

import coliseum.jpa.domain.BaseEntity;

@Entity
@Table(name = "PROJECT_MASTER")
public class Project extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	public Long getId() {
		return id;
	}

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

	public void setId(Long id) {
		this.id = id;
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