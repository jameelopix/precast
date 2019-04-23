package com.vme.precast.vendor.api;

import coliseum.service.ColiseumInterface;

public interface VendorComponent extends ColiseumInterface {

	public VendorServiceResponse createVendor(VendorServiceRequest vendorServiceRequest);

	public VendorServiceResponse getVendors(VendorServiceRequest vendorServiceRequest);

	public VendorServiceResponse updateVendor(VendorServiceRequest vendorServiceRequest);

	public VendorServiceResponse deleteVendor(VendorServiceRequest vendorServiceRequest);
}
