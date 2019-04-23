package com.vme.precast.purchaseorder.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class PurchaseOrderServiceResponse extends BaseServiceResponse {

	private static final long serialVersionUID = 1L;

	private List<PurchaseOrderDTO> purchaseOrderDTOList;

	public List<PurchaseOrderDTO> getPurchaseOrderDTOList() {
		return purchaseOrderDTOList;
	}

	public void setPurchaseOrderDTOList(List<PurchaseOrderDTO> purchaseOrderDTOList) {
		this.purchaseOrderDTOList = purchaseOrderDTOList;
	}
}