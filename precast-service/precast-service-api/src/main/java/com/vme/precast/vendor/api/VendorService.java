package com.vme.precast.vendor.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface VendorService extends BaseService {

 @FlowDescriptor(flow = "createvendor", request = "vendorServiceRequest", response = "vendorServiceResponse")
 public VendorServiceResponse createVendor(VendorServiceRequest vendorServiceRequest);

 @FlowDescriptor(flow = "getvendors", request = "vendorServiceRequest", response = "vendorServiceResponse")
 public VendorServiceResponse getVendors(VendorServiceRequest vendorServiceRequest);

 @FlowDescriptor(flow = "updatevendor", request = "vendorServiceRequest", response = "vendorServiceResponse")
 public VendorServiceResponse updateVendor(VendorServiceRequest vendorServiceRequest);

 @FlowDescriptor(flow = "deletevendor", request = "vendorServiceRequest", response = "vendorServiceResponse")
 public VendorServiceResponse deleteVendor(VendorServiceRequest vendorServiceRequest);
}