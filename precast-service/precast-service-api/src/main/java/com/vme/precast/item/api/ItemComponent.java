package com.vme.precast.item.api;

import coliseum.service.ColiseumInterface;

public interface ItemComponent extends ColiseumInterface {

 public ItemServiceResponse createItem(ItemServiceRequest itemServiceRequest);

 public ItemServiceResponse getItems(ItemServiceRequest itemServiceRequest);

 public ItemServiceResponse updateItem(ItemServiceRequest itemServiceRequest);

 public ItemServiceResponse deleteItem(ItemServiceRequest itemServiceRequest);
}
