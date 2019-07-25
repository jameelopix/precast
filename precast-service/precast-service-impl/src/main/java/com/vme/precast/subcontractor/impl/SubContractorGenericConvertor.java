package com.vme.precast.subcontractor.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import com.vme.precast.address.api.AddressDTO;
import com.vme.precast.domain.Address;
import com.vme.precast.domain.FinancialDetail;
import com.vme.precast.domain.SubContractor;
import com.vme.precast.financialdetail.api.FinancialDetailDTO;
import com.vme.precast.subcontractor.api.SubContractorDTO;

import coliseum.jpa.RepoUtils;
import coliseum.service.ConversionUtility;

public class SubContractorGenericConvertor implements GenericConverter {

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        Set<ConvertiblePair> convertiblePairs = new HashSet<>();
        convertiblePairs.add(new ConvertiblePair(SubContractor.class, SubContractorDTO.class));
        convertiblePairs.add(new ConvertiblePair(SubContractorDTO.class, SubContractor.class));
        return convertiblePairs;
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        Object target = null;
        if (sourceType.getType() == SubContractor.class && targetType.getType() == SubContractorDTO.class) {
            target = this.convertToSubContractorDTO((SubContractor) source);
        }
        if (sourceType.getType() == SubContractorDTO.class && targetType.getType() == SubContractor.class) {
            target = this.convertToSubContractor((SubContractorDTO) source);
        }
        return target;
    }

    private Object convertToSubContractor(SubContractorDTO source) {
        SubContractor target = new SubContractor();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setActive(source.getActive());
        return target;
    }

    private Object convertToSubContractorDTO(SubContractor source) {
        SubContractorDTO target = new SubContractorDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setActive(source.getActive());

        if (RepoUtils.isNotProxy(source.getAddress())) {
            target.setAddressDTO(
                    (AddressDTO) conversionUtility.convert(source.getAddress(), Address.class, AddressDTO.class));
        }
        target.setAddressId(source.getAddressId());

        if (RepoUtils.isNotProxy(source.getFinancialDetail())) {
            target.setFinancialDetailDTO((FinancialDetailDTO) conversionUtility.convert(source.getFinancialDetail(),
                    FinancialDetail.class, FinancialDetailDTO.class));
        }
        target.setFinancialDetailId(source.getFinancialDetailId());
        return target;
    }
}
