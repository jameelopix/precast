package com.vme.precast.address.api;

import coliseum.service.ColiseumInterface;

public interface AddressComponent extends ColiseumInterface {

	public AddressServiceResponse createAddress(AddressServiceRequest addressServiceRequest);

	public AddressServiceResponse getAddresss(AddressServiceRequest addressServiceRequest);

	public AddressServiceResponse updateAddress(AddressServiceRequest addressServiceRequest);

	public AddressServiceResponse deleteAddress(AddressServiceRequest addressServiceRequest);
}
