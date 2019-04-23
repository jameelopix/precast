package com.vme.precast.item.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ItemService extends BaseService {

 @FlowDescriptor(flow = "createitem", request = "itemServiceRequest", response = "itemServiceResponse")
 public ItemServiceResponse createItem(ItemServiceRequest itemServiceRequest);

 @FlowDescriptor(flow = "getitems", request = "itemServiceRequest", response = "itemServiceResponse")
 public ItemServiceResponse getItems(ItemServiceRequest itemServiceRequest);

 @FlowDescriptor(flow = "updateitem", request = "itemServiceRequest", response = "itemServiceResponse")
 public ItemServiceResponse updateItem(ItemServiceRequest itemServiceRequest);

 @FlowDescriptor(flow = "deleteitem", request = "itemServiceRequest", response = "itemServiceResponse")
 public ItemServiceResponse deleteItem(ItemServiceRequest itemServiceRequest);
}