package com.vme.precast.item.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ItemValidator extends ColiseumInterface {

 public ErrorDTO checkItemDuplicate(ItemServiceRequest itemServiceRequest);
}
