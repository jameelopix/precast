package com.vme.precast.cashtransfer.controller;

import java.util.List;

import com.vme.precast.cashtransfer.api.CashTransferDTO;
import com.vme.precast.cashtransfer.api.CashTransferSearchDTO;

import coliseum.web.BaseWidgetModel;

public class CashTransferWidgetModel extends BaseWidgetModel {

	private static final long serialVersionUID = 1L;

	private CashTransferDTO cashTransferDTO;

	private CashTransferSearchDTO cashTransferSearchDTO;

	private List<CashTransferDTO> cashTransferDTOs;

	public List<CashTransferDTO> getCashTransferDTOs() {
		return cashTransferDTOs;
	}

	public void setCashTransferDTOs(List<CashTransferDTO> cashTransferDTOs) {
		this.cashTransferDTOs = cashTransferDTOs;
	}

	public CashTransferDTO getCashTransferDTO() {
		return cashTransferDTO;
	}

	public void setCashTransferDTO(CashTransferDTO cashTransferDTO) {
		this.cashTransferDTO = cashTransferDTO;
	}

	public CashTransferSearchDTO getCashTransferSearchDTO() {
		return cashTransferSearchDTO;
	}

	public void setCashTransferSearchDTO(CashTransferSearchDTO cashTransferSearchDTO) {
		this.cashTransferSearchDTO = cashTransferSearchDTO;
	}
}
