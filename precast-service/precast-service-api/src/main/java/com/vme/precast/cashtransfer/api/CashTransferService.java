package com.vme.precast.cashtransfer.api;

import coliseum.service.BaseService;
import coliseum.service.FlowDescriptor;

public interface CashTransferService extends BaseService {

	@FlowDescriptor(flow = "createCashTransfer", request = "cashTransferServiceRequest", response = "cashTransferServiceResponse")
	public CashTransferServiceResponse createCashTransfer(CashTransferServiceRequest cashTransferServiceRequest);

	@FlowDescriptor(flow = "getCashTransfers", request = "cashTransferServiceRequest", response = "cashTransferServiceResponse")
	public CashTransferServiceResponse getCashTransfers(CashTransferServiceRequest cashTransferServiceRequest);

	@FlowDescriptor(flow = "updateCashTransfer", request = "cashTransferServiceRequest", response = "cashTransferServiceResponse")
	public CashTransferServiceResponse updateCashTransfer(CashTransferServiceRequest cashTransferServiceRequest);

	@FlowDescriptor(flow = "deleteCashTransfer", request = "cashTransferServiceRequest", response = "cashTransferServiceResponse")
	public CashTransferServiceResponse deleteCashTransfer(CashTransferServiceRequest cashTransferServiceRequest);
}
