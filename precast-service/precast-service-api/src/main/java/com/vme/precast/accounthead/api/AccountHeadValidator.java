package com.vme.precast.accounthead.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface AccountHeadValidator extends ColiseumInterface {

 public ErrorDTO checkAccountHeadDuplicate(AccountHeadServiceRequest accountHeadServiceRequest);
}
