package com.vme.precast.orderitem.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class OrderItemServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<OrderItemDTO> orderItemDTOList;

	public List<OrderItemDTO> getOrderItemDTOList() {
		return orderItemDTOList;
	}

	public void setOrderItemDTOList(List<OrderItemDTO> orderItemDTOList) {
		this.orderItemDTOList = orderItemDTOList;
	}
}