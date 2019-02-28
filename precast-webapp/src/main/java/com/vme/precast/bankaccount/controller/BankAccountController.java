package com.vme.precast.bankaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vme.precast.bankaccount.api.BankAccountDTO;
import com.vme.precast.bankaccount.api.BankAccountService;
import com.vme.precast.bankaccount.api.BankAccountServiceRequest;
import com.vme.precast.bankaccount.api.BankAccountServiceResponse;

@Controller
public class BankAccountController {

	@Autowired
	BankAccountService bankAccountService;

	@RequestMapping(value = "deleteBankAccount", method = RequestMethod.POST)
	@ResponseBody
	public BankAccountWidgetModel deleteBankAccount(@RequestBody BankAccountWidgetModel widgetModel) {
		BankAccountServiceRequest serviceRequest = new BankAccountServiceRequest();
		for (Long id : widgetModel.getIdsToDelete()) {
			BankAccountDTO bankAccountDTO = new BankAccountDTO();
			bankAccountDTO.setId(id);
			serviceRequest.setBankAccountDTO(bankAccountDTO);
			bankAccountService.deleteBankAccount(serviceRequest);
		}
		return null;
	}

	@RequestMapping(value = "createBankAccount", method = RequestMethod.POST)
	@ResponseBody
	public BankAccountWidgetModel createBankAccount(@RequestBody BankAccountWidgetModel widgetModel) {
		return this
				.constructWidgetModel(bankAccountService.createBankAccount(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "updateBankAccount", method = RequestMethod.POST)
	@ResponseBody
	public BankAccountWidgetModel updateBankAccount(@RequestBody BankAccountWidgetModel widgetModel) {
		return this
				.constructWidgetModel(bankAccountService.updateBankAccount(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "setDefaultBankAccount", method = RequestMethod.POST)
	@ResponseBody
	public BankAccountWidgetModel setDefaultBankAccount(@RequestBody BankAccountWidgetModel widgetModel) {
		return this.constructWidgetModel(
				bankAccountService.setDefaultBankAccount(this.constructServiceRequest(widgetModel)));
	}

	@RequestMapping(value = "getBankAccount", method = RequestMethod.POST)
	@ResponseBody
	public BankAccountWidgetModel getBankAccount(@RequestBody BankAccountWidgetModel widgetModel) {
		return this.constructWidgetModel(bankAccountService.getBankAccounts(this.constructServiceRequest(widgetModel)));
	}

	private BankAccountWidgetModel constructWidgetModel(BankAccountServiceResponse serviceResponse) {
		BankAccountWidgetModel widgetModel = new BankAccountWidgetModel();
		widgetModel.setBankAccountDTOs(serviceResponse.getBankAccountDTOs());
		widgetModel.setTotalRecords(serviceResponse.getTotalRecords());
		return widgetModel;
	}

	private BankAccountServiceRequest constructServiceRequest(BankAccountWidgetModel widgetModel) {
		BankAccountServiceRequest serviceRequest = new BankAccountServiceRequest();
		serviceRequest.setBankAccountDTO(widgetModel.getBankAccountDTO());
		serviceRequest.setBankAccountSearchDTO(widgetModel.getBankAccountSearchDTO());
		serviceRequest.setRecordstoFetch(widgetModel.getRecordstoFetch());
		serviceRequest.setPageIndex(widgetModel.getPageIndex());
		return serviceRequest;
	}
}