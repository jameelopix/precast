package com.vme.precast.address.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface AddressService extends BaseService {

    @FlowDescriptor(flow = "createaddress", request = "addressServiceRequest", response = "addressServiceResponse")
    public AddressServiceResponse createAddress(AddressServiceRequest addressServiceRequest);

    @FlowDescriptor(flow = "getaddresss", request = "addressServiceRequest", response = "addressServiceResponse")
    public AddressServiceResponse getAddresss(AddressServiceRequest addressServiceRequest);

    @FlowDescriptor(flow = "updateaddress", request = "addressServiceRequest", response = "addressServiceResponse")
    public AddressServiceResponse updateAddress(AddressServiceRequest addressServiceRequest);

    @FlowDescriptor(flow = "deleteaddress", request = "addressServiceRequest", response = "addressServiceResponse")
    public AddressServiceResponse deleteAddress(AddressServiceRequest addressServiceRequest);
}