package com.vme.precast.itembasicamountdetails.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ItemBasicAmountDetailsService extends BaseService {

 @FlowDescriptor(flow = "createitembasicamountdetails", request = "itemBasicAmountDetailsServiceRequest", response = "itemBasicAmountDetailsServiceResponse")
 public ItemBasicAmountDetailsServiceResponse createItemBasicAmountDetails(ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "getitembasicamountdetailss", request = "itemBasicAmountDetailsServiceRequest", response = "itemBasicAmountDetailsServiceResponse")
 public ItemBasicAmountDetailsServiceResponse getItemBasicAmountDetailss(ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "updateitembasicamountdetails", request = "itemBasicAmountDetailsServiceRequest", response = "itemBasicAmountDetailsServiceResponse")
 public ItemBasicAmountDetailsServiceResponse updateItemBasicAmountDetails(ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "deleteitembasicamountdetails", request = "itemBasicAmountDetailsServiceRequest", response = "itemBasicAmountDetailsServiceResponse")
 public ItemBasicAmountDetailsServiceResponse deleteItemBasicAmountDetails(ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest);
}