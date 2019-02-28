package com.vme.precast.cashtransfer.api;

import coliseum.service.ColiseumInterface;

public interface CashTransferComponent extends ColiseumInterface {

	public CashTransferServiceResponse createCashTransfer(CashTransferServiceRequest cashTransferServiceRequest);

	public CashTransferServiceResponse getCashTransfers(CashTransferServiceRequest cashTransferServiceRequest);

	public CashTransferServiceResponse updateCashTransfer(CashTransferServiceRequest cashTransferServiceRequest);

	public CashTransferServiceResponse deleteCashTransfer(CashTransferServiceRequest cashTransferServiceRequest);
}
