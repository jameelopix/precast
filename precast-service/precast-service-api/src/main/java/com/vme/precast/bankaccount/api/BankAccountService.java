package com.vme.precast.bankaccount.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface BankAccountService extends BaseService {

	@FlowDescriptor(flow = "createBankAccount", request = "bankAccountServiceRequest", response = "bankAccountServiceResponse")
	public BankAccountServiceResponse createBankAccount(BankAccountServiceRequest bankAccountServiceRequest);

	@FlowDescriptor(flow = "getBankAccounts", request = "bankAccountServiceRequest", response = "bankAccountServiceResponse")
	public BankAccountServiceResponse getBankAccounts(BankAccountServiceRequest bankAccountServiceRequest);

	@FlowDescriptor(flow = "setDefaultBankAccount", request = "bankAccountServiceRequest", response = "bankAccountServiceResponse")
	public BankAccountServiceResponse setDefaultBankAccount(BankAccountServiceRequest bankAccountServiceRequest);

	@FlowDescriptor(flow = "updateBankAccount", request = "bankAccountServiceRequest", response = "bankAccountServiceResponse")
	public BankAccountServiceResponse updateBankAccount(BankAccountServiceRequest bankAccountServiceRequest);

	@FlowDescriptor(flow = "deleteBankAccount", request = "bankAccountServiceRequest", response = "bankAccountServiceResponse")
	public BankAccountServiceResponse deleteBankAccount(BankAccountServiceRequest bankAccountServiceRequest);
}