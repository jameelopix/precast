package com.vme.precast.orderitem.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.OrderItem;
import com.vme.precast.domain.PurchaseOrder;
import com.vme.precast.orderitem.api.OrderItemComponent;
import com.vme.precast.orderitem.api.OrderItemDTO;
import com.vme.precast.orderitem.api.OrderItemSearchDTO;
import com.vme.precast.orderitem.api.OrderItemServiceRequest;
import com.vme.precast.orderitem.api.OrderItemServiceResponse;
import com.vme.precast.purchaseorder.api.PurchaseOrderDTO;
import com.vme.precast.purchaseorder.api.PurchaseOrderServiceRequest;
import com.vme.precast.repository.OrderItemRepo;
import com.vme.precast.repository.PurchaseOrderRepo;
import com.vme.precast.shared.UnitType;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class OrderItemComponentImpl implements OrderItemComponent {
    @Autowired
    OrderItemRepo orderItemRepo;
    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public OrderItemServiceResponse createOrderItem(OrderItemServiceRequest orderItemServiceRequest) {
        OrderItemDTO orderItemDTO = orderItemServiceRequest.getOrderItemDTO();
        OrderItem orderitem = (OrderItem) conversionUtility.convert(orderItemDTO, OrderItemDTO.class, OrderItem.class);
        if (orderItemDTO.getPurchaseOrderId() != null) {
            PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(orderItemDTO.getPurchaseOrderId()).get();
            orderitem.setPurchaseOrder(purchaseOrder);
        }
        orderItemRepo.save(orderitem);
        return null;
    }

    @Override
    public OrderItemServiceResponse getOrderItems(OrderItemServiceRequest orderItemServiceRequest) {
        List<OrderItem> orderItemList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        List<Association> associations = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        OrderItemSearchDTO orderItemSearchDTO = orderItemServiceRequest.getOrderItemSearchDTO();
        if (orderItemSearchDTO != null) {
            List<Long> idList = orderItemSearchDTO.getIdList();
            List<String> itemNameList = orderItemSearchDTO.getItemNameList();
            List<Long> purchaseOrderIdList = orderItemSearchDTO.getPurchaseOrderIdList();
            List<Double> quantityList = orderItemSearchDTO.getQuantityList();
            List<Double> rateList = orderItemSearchDTO.getRateList();
            List<UnitType> unitTypeList = orderItemSearchDTO.getUnitTypeList();

            FilterUtils.createEqualFilter(filters, OrderItemSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, OrderItemSearchDTO.ITEMNAME, itemNameList);
            FilterUtils.createEqualFilter(filters, OrderItemSearchDTO.PURCHASEORDERID, purchaseOrderIdList);
            FilterUtils.createEqualFilter(filters, OrderItemSearchDTO.QUANTITY, quantityList);
            FilterUtils.createEqualFilter(filters, OrderItemSearchDTO.RATE, rateList);
            FilterUtils.createEqualFilter(filters, OrderItemSearchDTO.UNITTYPE, unitTypeList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            if (orderItemSearchDTO.getPurchaseOrderNeeded()) {
                Association purchaseOrderassociation = new Association();
                purchaseOrderassociation.setFieldName("purchaseOrder");
                associations.add(purchaseOrderassociation);
            }

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(orderItemServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(orderItemServiceRequest.getRecordstoFetch());
        orderItemList = orderItemRepo.search(searchObject);

        List<OrderItemDTO> orderItemDTOList = new ArrayList<>();
        for (OrderItem target : orderItemList) {
            orderItemDTOList.add((OrderItemDTO) conversionUtility.convert(target, OrderItem.class, OrderItemDTO.class));
        }
        OrderItemServiceResponse orderItemServiceResponse = new OrderItemServiceResponse();
        orderItemServiceResponse.setOrderItemDTOList(orderItemDTOList);
        return orderItemServiceResponse;
    }

    @Override
    public OrderItemServiceResponse updateOrderItem(OrderItemServiceRequest orderItemServiceRequest) {
        OrderItemDTO source = orderItemServiceRequest.getOrderItemDTO();

        OrderItem target = orderItemRepo.findById(source.getId()).get();
        target.setId(source.getId());
        target.setItemName(source.getItemName());
        target.setQuantity(source.getQuantity());
        target.setRate(source.getRate());
        target.setUnitType(source.getUnitType());
        if (source.getPurchaseOrderId() != null && !source.getPurchaseOrderId().equals(target.getPurchaseOrderId())) {
            PurchaseOrder purchaseOrder = purchaseOrderRepo.findById(source.getPurchaseOrderId()).get();
            target.setPurchaseOrder(purchaseOrder);
        }

        orderItemRepo.save(target);
        return null;
    }

    @Override
    public OrderItemServiceResponse deleteOrderItem(OrderItemServiceRequest orderItemServiceRequest) {
        OrderItemDTO orderItemDTO = orderItemServiceRequest.getOrderItemDTO();
        orderItemRepo.deleteById(orderItemDTO.getId());
        return null;
    }

    @Override
    public OrderItemServiceResponse preprocess(OrderItemServiceRequest orderItemServiceRequest) {
        OrderItemDTO orderItemDTO = orderItemServiceRequest.getOrderItemDTO();

        Long purchaseOrderId = orderItemDTO.getPurchaseOrderId();
        if (purchaseOrderId == null) {
            purchaseOrderId = orderItemRepo.findById(orderItemDTO.getId()).get().getPurchaseOrderId();
        }

        PurchaseOrderServiceRequest purchaseOrderServiceRequest = new PurchaseOrderServiceRequest();
        PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
        purchaseOrderDTO.setId(purchaseOrderId);
        purchaseOrderServiceRequest.setPurchaseOrderDTO(purchaseOrderDTO);

        orderItemServiceRequest.setPurchaseOrderServiceRequest(purchaseOrderServiceRequest);
        return null;
    }
}