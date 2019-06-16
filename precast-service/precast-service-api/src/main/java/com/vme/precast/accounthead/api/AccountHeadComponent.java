package com.vme.precast.accounthead.api;

import coliseum.service.ColiseumInterface;

public interface AccountHeadComponent extends ColiseumInterface {

 public AccountHeadServiceResponse createAccountHead(AccountHeadServiceRequest accountHeadServiceRequest);

 public AccountHeadServiceResponse getAccountHeads(AccountHeadServiceRequest accountHeadServiceRequest);

 public AccountHeadServiceResponse updateAccountHead(AccountHeadServiceRequest accountHeadServiceRequest);

 public AccountHeadServiceResponse deleteAccountHead(AccountHeadServiceRequest accountHeadServiceRequest);
}
