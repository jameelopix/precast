package com.vme.precast.cashtransfer.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.cashtransfer.api.CashTransferDTO;
import com.vme.precast.domain.CashTransfer;

@Component
public class CashTransferGenericConvertor implements GenericConverter {

//	@Autowired
//	private ConversionService conversionService;

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(CashTransfer.class, CashTransferDTO.class));
		convertiblePairs.add(new ConvertiblePair(CashTransferDTO.class, CashTransfer.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == CashTransfer.class && targetType.getType() == CashTransferDTO.class) {
			target = this.convertToCompanyDTO((CashTransfer) source);
		}
		if (sourceType.getType() == CashTransferDTO.class && targetType.getType() == CashTransfer.class) {
			target = this.convertToCompany((CashTransferDTO) source);
		}
		return target;
	}

	private Object convertToCompany(CashTransferDTO source) {
		CashTransfer target = new CashTransfer();
		target.setId(source.getId());
		target.setSenderName(source.getSenderName());
		target.setReceiverName(source.getReceiverName());
		target.setSenderAccountNo(source.getSenderAccountNo());
		target.setReceiverAccountNo(source.getReceiverAccountNo());
		target.setChecknumber(source.getChecknumber());
		target.setTransferType(source.getTransferType());
		target.setAmount(source.getAmount());
		target.setTransferBy(source.getTransferBy());
		return target;
	}

	private Object convertToCompanyDTO(CashTransfer source) {
		CashTransferDTO target = new CashTransferDTO();
		target.setId(source.getId());
		target.setSenderName(source.getSenderName());
		target.setReceiverName(source.getReceiverName());
		target.setSenderAccountNo(source.getSenderAccountNo());
		target.setReceiverAccountNo(source.getReceiverAccountNo());
		target.setChecknumber(source.getChecknumber());
		target.setTransferType(source.getTransferType());
		target.setAmount(source.getAmount());
		target.setTransferBy(source.getTransferBy());
		return target;
	}
}
