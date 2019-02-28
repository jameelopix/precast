package com.vme.precast.cashtransfer.api;

import coliseum.service.BaseServiceRequest;

public class CashTransferServiceRequest extends BaseServiceRequest {

	private static final long serialVersionUID = 1L;

	private CashTransferDTO cashTransferDTO;

	private CashTransferSearchDTO cashTransferSearchDTO;

	public CashTransferSearchDTO getCashTransferSearchDTO() {
		return cashTransferSearchDTO;
	}

	public void setCashTransferSearchDTO(CashTransferSearchDTO cashTransferSearchDTO) {
		this.cashTransferSearchDTO = cashTransferSearchDTO;
	}

	public CashTransferDTO getCashTransferDTO() {
		return cashTransferDTO;
	}

	public void setCashTransferDTO(CashTransferDTO cashTransferDTO) {
		this.cashTransferDTO = cashTransferDTO;
	}
}
