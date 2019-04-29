package com.vme.precast.accountdetails.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface AccountDetailsValidator extends ColiseumInterface {

 public ErrorDTO checkAccountDetailsDuplicate(AccountDetailsServiceRequest accountDetailsServiceRequest);
}
