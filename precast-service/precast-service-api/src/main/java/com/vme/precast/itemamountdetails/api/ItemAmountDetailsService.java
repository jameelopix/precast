package com.vme.precast.itemamountdetails.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ItemAmountDetailsService extends BaseService {

 @FlowDescriptor(flow = "createitemamountdetails", request = "itemAmountDetailsServiceRequest", response = "itemAmountDetailsServiceResponse")
 public ItemAmountDetailsServiceResponse createItemAmountDetails(ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "getitemamountdetailss", request = "itemAmountDetailsServiceRequest", response = "itemAmountDetailsServiceResponse")
 public ItemAmountDetailsServiceResponse getItemAmountDetailss(ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "updateitemamountdetails", request = "itemAmountDetailsServiceRequest", response = "itemAmountDetailsServiceResponse")
 public ItemAmountDetailsServiceResponse updateItemAmountDetails(ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "deleteitemamountdetails", request = "itemAmountDetailsServiceRequest", response = "itemAmountDetailsServiceResponse")
 public ItemAmountDetailsServiceResponse deleteItemAmountDetails(ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest);
}