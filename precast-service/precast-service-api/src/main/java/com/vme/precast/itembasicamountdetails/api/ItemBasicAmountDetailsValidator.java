package com.vme.precast.itembasicamountdetails.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ItemBasicAmountDetailsValidator extends ColiseumInterface {

 public ErrorDTO checkItemBasicAmountDetailsDuplicate(ItemBasicAmountDetailsServiceRequest itemBasicAmountDetailsServiceRequest);
}
