package com.vme.precast.orderitem.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.orderitem.api.OrderItemDTO;
import com.vme.precast.orderitem.api.OrderItemServiceRequest;
import com.vme.precast.orderitem.api.OrderItemValidator;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;
import com.vme.precast.repository.OrderItemRepo;

import coliseum.service.ErrorDTO;

public class OrderItemValidatorImpl implements OrderItemValidator {
    @Autowired
    OrderItemRepo orderItemRepo;

    @Override
    public ErrorDTO checkOrderItemDuplicate(OrderItemServiceRequest orderItemServiceRequest) {
        return null;
    }

    @Override
    public ErrorDTO isPurchaseOrderClosed(OrderItemServiceRequest orderItemServiceRequest) {
        OrderItemDTO orderItemDTO = orderItemServiceRequest.getOrderItemDTO();
        PurchaseOrderServiceRequest purchaseOrderServiceRequest = new PurchaseOrderServiceRequest();
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setId(orderItemDTO.getPurchaseOrderId());
        purchaseOrderServiceRequest.setPurchaseOrderDTO(purchaseOrderDTO);

        return null;
    }

    @Override
    public ErrorDTO isPurchaseOrderIssued(OrderItemServiceRequest orderItemServiceRequest) {
// TODO Auto-generated method stub
        return null;
    }
}