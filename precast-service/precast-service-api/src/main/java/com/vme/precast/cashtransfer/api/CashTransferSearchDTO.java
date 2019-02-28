package com.vme.precast.cashtransfer.api;

import java.util.List;

import com.vme.precast.shared.TransferBy;
import com.vme.precast.shared.TransferType;

import coliseum.service.BaseSearchDTO;

public class CashTransferSearchDTO extends BaseSearchDTO {

	private static final long serialVersionUID = 1L;

	private List<String> senderNames;

	private List<String> receiverNames;

	private List<String> senderAccountNos;

	private List<String> receiverAccountNos;

	private List<String> checknumbers;

	private List<TransferType> transferTypes;

	private List<Double> amounts;

	private List<TransferBy> transferBys;

	public List<String> getSenderNames() {
		return senderNames;
	}

	public List<String> getReceiverNames() {
		return receiverNames;
	}

	public List<String> getSenderAccountNos() {
		return senderAccountNos;
	}

	public List<String> getReceiverAccountNos() {
		return receiverAccountNos;
	}

	public List<String> getChecknumbers() {
		return checknumbers;
	}

	public List<TransferType> getTransferTypes() {
		return transferTypes;
	}

	public List<Double> getAmounts() {
		return amounts;
	}

	public void setSenderNames(List<String> senderNames) {
		this.senderNames = senderNames;
	}

	public void setReceiverNames(List<String> receiverNames) {
		this.receiverNames = receiverNames;
	}

	public void setSenderAccountNos(List<String> senderAccountNos) {
		this.senderAccountNos = senderAccountNos;
	}

	public void setReceiverAccountNos(List<String> receiverAccountNos) {
		this.receiverAccountNos = receiverAccountNos;
	}

	public void setChecknumbers(List<String> checknumbers) {
		this.checknumbers = checknumbers;
	}

	public void setTransferTypes(List<TransferType> transferTypes) {
		this.transferTypes = transferTypes;
	}

	public void setAmounts(List<Double> amounts) {
		this.amounts = amounts;
	}

	public List<TransferBy> getTransferBys() {
		return transferBys;
	}

	public void setTransferBys(List<TransferBy> transferBys) {
		this.transferBys = transferBys;
	}
}
