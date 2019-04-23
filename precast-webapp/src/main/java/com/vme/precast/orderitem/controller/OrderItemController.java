package com.vme.precast.orderitem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.orderitem.api.OrderItemDTO;
import com.vme.precast.orderitem.api.OrderItemService;
import com.vme.precast.orderitem.api.OrderItemServiceRequest;
import com.vme.precast.orderitem.api.OrderItemServiceResponse;

@Controller
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;

	@RequestMapping(value = "deleteOrderItem", method = RequestMethod.POST)
	@ResponseBody
	public OrderItemClientModel deleteOrderItem(@RequestBody OrderItemClientModel orderItemClientModel) {
		OrderItemServiceRequest orderItemServiceRequest = new OrderItemServiceRequest();
		for (Long id : orderItemClientModel.getIdsToDelete()) {
			OrderItemDTO orderItemDTO = new OrderItemDTO();
			orderItemDTO.setId(id);
			orderItemServiceRequest.setOrderItemDTO(orderItemDTO);
			orderItemService.deleteOrderItem(orderItemServiceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createOrderItem", method = RequestMethod.POST)
	@ResponseBody
	public OrderItemClientModel createOrderItem(@Valid @RequestBody OrderItemClientModel orderItemClientModel) {
		return this.constructWidgetModel(
				orderItemService.createOrderItem(this.constructServiceRequest(orderItemClientModel)));
	}

	@RequestMapping(value = "updateOrderItem", method = RequestMethod.POST)
	@ResponseBody
	public OrderItemClientModel updateOrderItem(@Valid @RequestBody OrderItemClientModel orderItemClientModel) {
		return this.constructWidgetModel(
				orderItemService.updateOrderItem(this.constructServiceRequest(orderItemClientModel)));
	}

	@RequestMapping(value = "getOrderItem", method = RequestMethod.POST)
	@ResponseBody
	public OrderItemClientModel getOrderItem(@RequestBody OrderItemClientModel orderItemClientModel) {
		return this.constructWidgetModel(
				orderItemService.getOrderItems(this.constructServiceRequest(orderItemClientModel)));
	}

	private OrderItemClientModel constructWidgetModel(OrderItemServiceResponse serviceResponse) {
		OrderItemClientModel orderItemClientModel = null;
		if (serviceResponse != null) {
			orderItemClientModel = new OrderItemClientModel();
			orderItemClientModel.setOrderItemDTOList(serviceResponse.getOrderItemDTOList());
			orderItemClientModel.setTotalRecords(serviceResponse.getTotalRecords());
		}
		return orderItemClientModel;
	}

	private OrderItemServiceRequest constructServiceRequest(OrderItemClientModel orderItemClientModel) {
		OrderItemServiceRequest orderItemServiceRequest = new OrderItemServiceRequest();
		orderItemServiceRequest.setOrderItemDTO(orderItemClientModel.getOrderItemDTO());
		orderItemServiceRequest.setOrderItemSearchDTO(orderItemClientModel.getOrderItemSearchDTO());
		orderItemServiceRequest.setRecordstoFetch(orderItemClientModel.getRecordstoFetch());
		orderItemServiceRequest.setPageIndex(orderItemClientModel.getPageIndex());
		return orderItemServiceRequest;
	}
}
