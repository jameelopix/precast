package com.vme.precast.cashtransfer.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class CashTransferServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<CashTransferDTO> cashTransferDTOs;

	public List<CashTransferDTO> getCashTransferDTOs() {
		return cashTransferDTOs;
	}

	public void setCashTransferDTOs(List<CashTransferDTO> cashTransferDTOs) {
		this.cashTransferDTOs = cashTransferDTOs;
	}
}