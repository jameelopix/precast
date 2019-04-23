package com.vme.precast.orderitem.api;

import coliseum.service.ColiseumInterface;

public interface OrderItemComponent extends ColiseumInterface {

 public OrderItemServiceResponse createProject(OrderItemServiceRequest orderItemServiceRequest);

 public OrderItemServiceResponse getProjects(OrderItemServiceRequest orderItemServiceRequest);

 public OrderItemServiceResponse updateProject(OrderItemServiceRequest orderItemServiceRequest);

 public OrderItemServiceResponse deleteProject(OrderItemServiceRequest orderItemServiceRequest);
}
