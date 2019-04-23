package com.vme.precast.orderitem.api;

import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.shared.UnitType;

import coliseum.service.BaseDTO;

public class OrderItemDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String itemName;

	private Double quantity;

	private Double rate;

	private UnitType unitType;

	private PurchaseOrderDTO purchaseOrderDTO;

	private Long purchaseOrderId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	public UnitType getUnitType() {
		return unitType;
	}

	public void setUnitType(UnitType unitType) {
		this.unitType = unitType;
	}

	public PurchaseOrderDTO getPurchaseOrderDTO() {
		return purchaseOrderDTO;
	}

	public void setPurchaseOrderDTO(PurchaseOrderDTO purchaseOrderDTO) {
		this.purchaseOrderDTO = purchaseOrderDTO;
	}

	public Long getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Long purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
}