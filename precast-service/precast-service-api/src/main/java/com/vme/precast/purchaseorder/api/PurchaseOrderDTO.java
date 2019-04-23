package com.vme.precast.purchaseorder.api;

import java.util.Date;
import java.util.List;

import com.vme.precast.orderitem.api.OrderItemDTO;

import coliseum.service.BaseDTO;

public class PurchaseOrderDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String purchaseOrderNo;

	private Date purchaseDate;

	private List<OrderItemDTO> orderItemDTOList;

	private List<Long> orderItemIdList;

	private Boolean issued;

	private Boolean closed;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<OrderItemDTO> getOrderItemDTOList() {
		return orderItemDTOList;
	}

	public void setOrderItemDTOList(List<OrderItemDTO> orderItemDTOList) {
		this.orderItemDTOList = orderItemDTOList;
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

	public List<Long> getOrderItemIdList() {
		return orderItemIdList;
	}

	public void setOrderItemIdList(List<Long> orderItemIdList) {
		this.orderItemIdList = orderItemIdList;
	}

}