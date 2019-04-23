package com.vme.precast.orderitem.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface OrderItemValidator extends ColiseumInterface {

 public ErrorDTO checkOrderItemDuplicate(OrderItemServiceRequest orderItemServiceRequest);
}
