package com.vme.precast.orderitem.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface OrderItemService extends BaseService {

    @FlowDescriptor(flow = "createorderitem", request = "orderItemServiceRequest", response = "orderItemServiceResponse")
    public OrderItemServiceResponse createOrderItem(OrderItemServiceRequest orderItemServiceRequest);

    @FlowDescriptor(flow = "getorderitems", request = "orderItemServiceRequest", response = "orderItemServiceResponse")
    public OrderItemServiceResponse getOrderItems(OrderItemServiceRequest orderItemServiceRequest);

    @FlowDescriptor(flow = "updateorderitem", request = "orderItemServiceRequest", response = "orderItemServiceResponse")
    public OrderItemServiceResponse updateOrderItem(OrderItemServiceRequest orderItemServiceRequest);

    @FlowDescriptor(flow = "deleteorderitem", request = "orderItemServiceRequest", response = "orderItemServiceResponse")
    public OrderItemServiceResponse deleteOrderItem(OrderItemServiceRequest orderItemServiceRequest);
}