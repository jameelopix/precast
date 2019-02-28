package com.vme.precast.bankaccount.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.stereotype.Component;

import com.vme.precast.bankaccount.api.BankAccountDTO;
import com.vme.precast.domain.BankAccount;

@Component
public class BankAccountGenericConvertor implements GenericConverter {

//	@Autowired
//	private ConversionService conversionService;

	@Override
	public Set<ConvertiblePair> getConvertibleTypes() {
		Set<ConvertiblePair> convertiblePairs = new HashSet<>();
		convertiblePairs.add(new ConvertiblePair(BankAccount.class, BankAccountDTO.class));
		convertiblePairs.add(new ConvertiblePair(BankAccountDTO.class, BankAccount.class));
		return convertiblePairs;
	}

	@Override
	public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
		Object target = null;
		if (sourceType.getType() == BankAccount.class && targetType.getType() == BankAccountDTO.class) {
			target = this.convertToCompanyDTO((BankAccount) source);
		}
		if (sourceType.getType() == BankAccountDTO.class && targetType.getType() == BankAccount.class) {
			target = this.convertToCompany((BankAccountDTO) source);
		}
		return target;
	}

	private Object convertToCompany(BankAccountDTO source) {
		BankAccount target = new BankAccount();
		target.setId(source.getId());
		target.setAccountNo(source.getAccountNo());
		target.setDefaultAccount(source.getDefaultAccount());
		target.setDisabled(source.getDisabled());
		target.setCompanyId(source.getCompanyId());
		return target;
	}

	private Object convertToCompanyDTO(BankAccount source) {
		BankAccountDTO target = new BankAccountDTO();
		target.setId(source.getId());
		target.setAccountNo(source.getAccountNo());
		target.setDefaultAccount(source.getDefaultAccount());
		target.setDisabled(source.getDisabled());
		target.setCompanyId(source.getCompanyId());

//		if (source.getCompany() != null && source.getCompany() instanceof Company) {
//			CompanyDTO companyDTO = this.conversionService.convert(source.getCompany(), CompanyDTO.class);
//			target.setCompanyDTO(companyDTO);
//		}
		return target;
	}
}
