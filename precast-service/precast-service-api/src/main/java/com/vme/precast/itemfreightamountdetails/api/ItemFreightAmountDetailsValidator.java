package com.vme.precast.itemfreightamountdetails.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ItemFreightAmountDetailsValidator extends ColiseumInterface {

 public ErrorDTO checkItemFreightAmountDetailsDuplicate(ItemFreightAmountDetailsServiceRequest itemFreightAmountDetailsServiceRequest);
}
