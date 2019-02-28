package com.vme.precast.cashtransfer.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import com.vme.precast.cashtransfer.api.CashTransferComponent;
import com.vme.precast.cashtransfer.api.CashTransferDTO;
import com.vme.precast.cashtransfer.api.CashTransferSearchDTO;
import com.vme.precast.cashtransfer.api.CashTransferServiceRequest;
import com.vme.precast.cashtransfer.api.CashTransferServiceResponse;
import com.vme.precast.domain.CashTransfer;
import com.vme.precast.repository.CashTransferRepo;
import com.vme.precast.shared.TransferBy;
import com.vme.precast.shared.TransferType;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;

public class CashTransferComponentImpl implements CashTransferComponent {

	@Autowired
	private CashTransferRepo cashTransferRepo;

	@Autowired
	private ConversionService conversionService;

	@Override
	public CashTransferServiceResponse createCashTransfer(CashTransferServiceRequest cashTransferServiceRequest) {
		CashTransferDTO cashTransferDTO = cashTransferServiceRequest.getCashTransferDTO();
		CashTransfer cashTransfer = conversionService.convert(cashTransferDTO, CashTransfer.class);
		cashTransferRepo.save(cashTransfer);
		return new CashTransferServiceResponse();
	}

	@Override
	public CashTransferServiceResponse getCashTransfers(CashTransferServiceRequest cashTransferServiceRequest) {
		List<CashTransfer> cashTransfers = new ArrayList<>();
		List<Filter> filters = new ArrayList<>();
		SearchObject searchObject = new SearchObject();

		CashTransferSearchDTO searchDTO = cashTransferServiceRequest.getCashTransferSearchDTO();
		if (searchDTO != null) {
			List<Long> ids = searchDTO.getIds();
			List<String> senderNames = searchDTO.getSenderNames();
			List<String> receiverNames = searchDTO.getReceiverNames();
			List<String> senderAccountNos = searchDTO.getSenderAccountNos();
			List<String> receiverAccountNos = searchDTO.getReceiverAccountNos();
			List<String> checknumbers = searchDTO.getChecknumbers();
			List<TransferType> transferTypes = searchDTO.getTransferTypes();
			List<Double> amounts = searchDTO.getAmounts();
			List<TransferBy> transferBys = searchDTO.getTransferBys();

			createEqualFilter(filters, CashTransferDTO.ID, ids);
			createEqualFilter(filters, CashTransferDTO.SENDERNAME, senderNames);
			createEqualFilter(filters, CashTransferDTO.RECEIVERNAME, receiverNames);
			createEqualFilter(filters, CashTransferDTO.SENDERACCOUNTNO, senderAccountNos);
			createEqualFilter(filters, CashTransferDTO.RECEIVERACCOUNTNO, receiverAccountNos);
			createEqualFilter(filters, CashTransferDTO.CHECKNUMBER, checknumbers);
			createEqualFilter(filters, CashTransferDTO.TRANSFERTYPE, transferTypes);
			createEqualFilter(filters, CashTransferDTO.AMOUNT, amounts);
			createEqualFilter(filters, CashTransferDTO.TRANSFERBY, transferBys);

			if (CollectionUtils.isNotEmpty(filters)) {
				searchObject.setFilters(filters);
			}
		}

		searchObject.setPageIndex(cashTransferServiceRequest.getPageIndex());
		searchObject.setRecordstoFetch(cashTransferServiceRequest.getRecordstoFetch());
		cashTransfers = cashTransferRepo.search(searchObject);

		List<CashTransferDTO> cashTransferDTOs = new ArrayList<>();
		for (CashTransfer target : cashTransfers) {
			CashTransferDTO cashTransferDTO = conversionService.convert(target, CashTransferDTO.class);
			cashTransferDTOs.add(cashTransferDTO);
		}
		CashTransferServiceResponse cashTransferServiceResponse = new CashTransferServiceResponse();
		cashTransferServiceResponse.setCashTransferDTOs(cashTransferDTOs);
		return cashTransferServiceResponse;
	}

	@Override
	public CashTransferServiceResponse updateCashTransfer(CashTransferServiceRequest cashTransferServiceRequest) {
		CashTransferDTO source = cashTransferServiceRequest.getCashTransferDTO();

		CashTransfer target = cashTransferRepo.findById(source.getId()).get();
		target.setId(source.getId());
		target.setSenderName(source.getSenderName());
		target.setReceiverName(source.getReceiverName());
		target.setSenderAccountNo(source.getSenderAccountNo());
		target.setReceiverAccountNo(source.getReceiverAccountNo());
		target.setChecknumber(source.getChecknumber());
		target.setTransferType(source.getTransferType());
		target.setAmount(source.getAmount());
		target.setTransferBy(source.getTransferBy());

		cashTransferRepo.save(target);

		return new CashTransferServiceResponse();
	}

	@Override
	public CashTransferServiceResponse deleteCashTransfer(CashTransferServiceRequest cashTransferServiceRequest) {
		CashTransferDTO source = cashTransferServiceRequest.getCashTransferDTO();
		cashTransferRepo.deleteById(source.getId());

		return new CashTransferServiceResponse();
	}
}