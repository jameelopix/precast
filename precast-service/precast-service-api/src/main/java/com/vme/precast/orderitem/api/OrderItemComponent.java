package com.vme.precast.orderitem.api;

import coliseum.service.ColiseumInterface;

public interface OrderItemComponent extends ColiseumInterface {

    public OrderItemServiceResponse createOrderItem(OrderItemServiceRequest orderItemServiceRequest);

    public OrderItemServiceResponse getOrderItems(OrderItemServiceRequest orderItemServiceRequest);

    public OrderItemServiceResponse updateOrderItem(OrderItemServiceRequest orderItemServiceRequest);

    public OrderItemServiceResponse deleteOrderItem(OrderItemServiceRequest orderItemServiceRequest);

    public OrderItemServiceResponse preprocess(OrderItemServiceRequest orderItemServiceRequest);
}
