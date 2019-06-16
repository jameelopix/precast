package com.vme.precast.accounthead.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface AccountHeadService extends BaseService {

 @FlowDescriptor(flow = "createaccounthead", request = "accountHeadServiceRequest", response = "accountHeadServiceResponse")
 public AccountHeadServiceResponse createAccountHead(AccountHeadServiceRequest accountHeadServiceRequest);

 @FlowDescriptor(flow = "getaccountheads", request = "accountHeadServiceRequest", response = "accountHeadServiceResponse")
 public AccountHeadServiceResponse getAccountHeads(AccountHeadServiceRequest accountHeadServiceRequest);

 @FlowDescriptor(flow = "updateaccounthead", request = "accountHeadServiceRequest", response = "accountHeadServiceResponse")
 public AccountHeadServiceResponse updateAccountHead(AccountHeadServiceRequest accountHeadServiceRequest);

 @FlowDescriptor(flow = "deleteaccounthead", request = "accountHeadServiceRequest", response = "accountHeadServiceResponse")
 public AccountHeadServiceResponse deleteAccountHead(AccountHeadServiceRequest accountHeadServiceRequest);
}