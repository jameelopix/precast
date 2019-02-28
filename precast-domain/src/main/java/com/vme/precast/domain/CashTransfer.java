package com.vme.precast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.vme.precast.shared.TransferBy;
import com.vme.precast.shared.TransferType;

import coliseum.jpa.domain.BaseEntity;

@Entity
public class CashTransfer extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String senderName;

	private String receiverName;

	private String senderAccountNo;

	private String receiverAccountNo;

	private String checknumber;

	private TransferType transferType;

	private Double amount;

	private TransferBy transferBy;

	public Long getId() {
		return id;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getSenderAccountNo() {
		return senderAccountNo;
	}

	public String getReceiverAccountNo() {
		return receiverAccountNo;
	}

	public String getChecknumber() {
		return checknumber;
	}

	public TransferType getTransferType() {
		return transferType;
	}

	public Double getAmount() {
		return amount;
	}

	public TransferBy getTransferBy() {
		return transferBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setSenderAccountNo(String senderAccountNo) {
		this.senderAccountNo = senderAccountNo;
	}

	public void setReceiverAccountNo(String receiverAccountNo) {
		this.receiverAccountNo = receiverAccountNo;
	}

	public void setChecknumber(String checknumber) {
		this.checknumber = checknumber;
	}

	public void setTransferType(TransferType transferType) {
		this.transferType = transferType;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setTransferBy(TransferBy transferBy) {
		this.transferBy = transferBy;
	}
}