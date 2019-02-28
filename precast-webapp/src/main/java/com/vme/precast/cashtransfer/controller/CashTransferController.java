package com.vme.precast.cashtransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.cashtransfer.api.CashTransferDTO;
import com.vme.precast.cashtransfer.api.CashTransferService;
import com.vme.precast.cashtransfer.api.CashTransferServiceRequest;
import com.vme.precast.cashtransfer.api.CashTransferServiceResponse;

@Controller
public class CashTransferController {

	@Autowired
	CashTransferService cashTransferService;

	@RequestMapping(value = "deleteCashTransfer", method = RequestMethod.POST)
	@ResponseBody
	public CashTransferWidgetModel deleteCashTransfer(@RequestBody CashTransferWidgetModel widgetModel) {
		CashTransferServiceRequest serviceRequest = new CashTransferServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			CashTransferDTO cashTransferDTO = new CashTransferDTO();
			cashTransferDTO.setId(id);
			serviceRequest.setCashTransferDTO(cashTransferDTO);
			cashTransferService.deleteCashTransfer(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createCashTransfer", method = RequestMethod.POST)
	@ResponseBody
	public CashTransferWidgetModel createCashTransfer(@RequestBody CashTransferWidgetModel widgetModel) {
		return this.constructWidgetModel(
				cashTransferService.createCashTransfer(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateCashTransfer", method = RequestMethod.POST)
	@ResponseBody
	public CashTransferWidgetModel updateCashTransfer(@RequestBody CashTransferWidgetModel widgetModel) {
		return this.constructWidgetModel(
				cashTransferService.updateCashTransfer(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getCashTransfer", method = RequestMethod.POST)
	@ResponseBody
	public CashTransferWidgetModel getCashTransfer(@RequestBody CashTransferWidgetModel widgetModel) {
		return this
				.constructWidgetModel(cashTransferService.getCashTransfers(this.constructServiceRequest(widgetModel)));
	}

	private CashTransferWidgetModel constructWidgetModel(CashTransferServiceResponse serviceResponse) {
		CashTransferWidgetModel widgetModel = new CashTransferWidgetModel();
		widgetModel.setCashTransferDTOs(serviceResponse.getCashTransferDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private CashTransferServiceRequest constructServiceRequest(CashTransferWidgetModel widgetModel) {
		CashTransferServiceRequest serviceRequest = new CashTransferServiceRequest();
		serviceRequest.setCashTransferDTO(widgetModel.getCashTransferDTO());
		serviceRequest.setCashTransferSearchDTO(widgetModel.getCashTransferSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}