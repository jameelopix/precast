package com.vme.precast.accountdetails.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface AccountDetailsService extends BaseService {

    @FlowDescriptor(flow = "createaccountdetails", request = "accountDetailsServiceRequest", response = "accountDetailsServiceResponse")
    public AccountDetailsServiceResponse createAccountDetails(
            AccountDetailsServiceRequest accountDetailsServiceRequest);

    @FlowDescriptor(flow = "getaccountdetailss", request = "accountDetailsServiceRequest", response = "accountDetailsServiceResponse")
    public AccountDetailsServiceResponse getAccountDetailss(AccountDetailsServiceRequest accountDetailsServiceRequest);

    @FlowDescriptor(flow = "updateaccountdetails", request = "accountDetailsServiceRequest", response = "accountDetailsServiceResponse")
    public AccountDetailsServiceResponse updateAccountDetails(
            AccountDetailsServiceRequest accountDetailsServiceRequest);

    @FlowDescriptor(flow = "deleteaccountdetails", request = "accountDetailsServiceRequest", response = "accountDetailsServiceResponse")
    public AccountDetailsServiceResponse deleteAccountDetails(
            AccountDetailsServiceRequest accountDetailsServiceRequest);
}