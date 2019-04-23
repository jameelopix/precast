package com.vme.precast.vendor.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface VendorValidator extends ColiseumInterface {

 public ErrorDTO checkVendorDuplicate(VendorServiceRequest vendorServiceRequest);
}
