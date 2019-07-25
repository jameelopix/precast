package com.vme.precast.address.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface AddressValidator extends ColiseumInterface {

    public ErrorDTO checkAddressDuplicate(AddressServiceRequest addressServiceRequest);
}
