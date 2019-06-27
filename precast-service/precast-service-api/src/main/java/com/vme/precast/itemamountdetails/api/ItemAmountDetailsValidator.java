package com.vme.precast.itemamountdetails.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ItemAmountDetailsValidator extends ColiseumInterface {

 public ErrorDTO checkItemAmountDetailsDuplicate(ItemAmountDetailsServiceRequest itemAmountDetailsServiceRequest);
}
