package com.vme.precast.orderitem.controller;

import java.util.List;

import com.vme.precast.orderitem.api.OrderItemDTO;
import com.vme.precast.orderitem.api.OrderItemSearchDTO;

import coliseum.web.BaseClientModel;

public class OrderItemClientModel extends BaseClientModel {

	private static final long serialVersionUID = 1L;

	private OrderItemDTO orderItemDTO;

	private OrderItemSearchDTO orderItemSearchDTO;

	private List<OrderItemDTO> orderItemDTOList;

	public OrderItemDTO getOrderItemDTO() {
		return orderItemDTO;
	}

	public void setOrderItemDTO(OrderItemDTO orderItemDTO) {
		this.orderItemDTO = orderItemDTO;
	}

	public OrderItemSearchDTO getOrderItemSearchDTO() {
		return orderItemSearchDTO;
	}

	public void setOrderItemSearchDTO(OrderItemSearchDTO orderItemSearchDTO) {
		this.orderItemSearchDTO = orderItemSearchDTO;
	}

	public List<OrderItemDTO> getOrderItemDTOList() {
		return orderItemDTOList;
	}

	public void setOrderItemDTOList(List<OrderItemDTO> orderItemDTOList) {
		this.orderItemDTOList = orderItemDTOList;
	}
}
