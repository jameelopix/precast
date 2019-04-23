package com.vme.precast.purchaseorder.api;

import java.util.Date;
import java.util.List;

import coliseum.service.BaseSearchDTO;

public class PurchaseOrderSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> purchaseOrderNo;

	private List<Date> purchaseDate;

	private List<Long> orderItemIdList;

	private Boolean issued;

	private Boolean closed;

	public List<String> getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(List<String> purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public List<Date> getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(List<Date> purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<Long> getOrderItemIdList() {
		return orderItemIdList;
	}

	public void setOrderItemIdList(List<Long> orderItemIdList) {
		this.orderItemIdList = orderItemIdList;
	}

	public Boolean getIssued() {
		return issued;
	}

	public void setIssued(Boolean issued) {
		this.issued = issued;
	}

	public Boolean getClosed() {
		return closed;
	}

	public void setClosed(Boolean closed) {
		this.closed = closed;
	}
}