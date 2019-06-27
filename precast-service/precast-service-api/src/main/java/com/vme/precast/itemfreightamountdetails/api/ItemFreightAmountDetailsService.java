package com.vme.precast.itemfreightamountdetails.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface ItemFreightAmountDetailsService extends BaseService {

 @FlowDescriptor(flow = "createitemfreightamountdetails", request = "itemFreightAmountDetailsServiceRequest", response = "itemFreightAmountDetailsServiceResponse")
 public ItemFreightAmountDetailsServiceResponse createItemFreightAmountDetails(ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "getitemfreightamountdetailss", request = "itemFreightAmountDetailsServiceRequest", response = "itemFreightAmountDetailsServiceResponse")
 public ItemFreightAmountDetailsServiceResponse getItemFreightAmountDetailss(ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "updateitemfreightamountdetails", request = "itemFreightAmountDetailsServiceRequest", response = "itemFreightAmountDetailsServiceResponse")
 public ItemFreightAmountDetailsServiceResponse updateItemFreightAmountDetails(ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest);

 @FlowDescriptor(flow = "deleteitemfreightamountdetails", request = "itemFreightAmountDetailsServiceRequest", response = "itemFreightAmountDetailsServiceResponse")
 public ItemFreightAmountDetailsServiceResponse deleteItemFreightAmountDetails(ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest);
}