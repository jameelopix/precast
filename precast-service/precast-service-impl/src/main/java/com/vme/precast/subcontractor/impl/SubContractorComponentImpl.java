package com.vme.precast.subcontractor.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.address.api.AddressDTO;
import com.vme.precast.address.api.AddressServiceRequest;
import com.vme.precast.address.api.AddressServiceResponse;
import com.vme.precast.domain.Address;
import com.vme.precast.domain.FinancialDetail;
import com.vme.precast.domain.SubContractor;
import com.vme.precast.financialdetail.api.FinancialDetailDTO;
import com.vme.precast.financialdetail.api.FinancialDetailServiceRequest;
import com.vme.precast.financialdetail.api.FinancialDetailServiceResponse;
import com.vme.precast.repository.AddressRepo;
import com.vme.precast.repository.FinancialDetailRepo;
import com.vme.precast.repository.SubContractorRepo;
import com.vme.precast.subcontractor.api.SubContractorComponent;
import com.vme.precast.subcontractor.api.SubContractorDTO;
import com.vme.precast.subcontractor.api.SubContractorSearchDTO;
import com.vme.precast.subcontractor.api.SubContractorServiceRequest;
import com.vme.precast.subcontractor.api.SubContractorServiceResponse;

import coliseum.jpa.Association;
import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.AssociationUtils;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class SubContractorComponentImpl implements SubContractorComponent {

    @Autowired
    SubContractorRepo subContractorRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    FinancialDetailRepo financialDetailRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public SubContractorServiceResponse createSubContractor(SubContractorServiceRequest subContractorServiceRequest) {
        SubContractorDTO subContractorDTO = subContractorServiceRequest.getSubContractorDTO();
        SubContractor subcontractor = (SubContractor) conversionUtility.convert(subContractorDTO,
                SubContractorDTO.class, SubContractor.class);

        subcontractor.setActive(true);
        if (subContractorDTO.getAddressId() != null) {
            Address address = addressRepo.findById(subContractorDTO.getAddressId()).get();
            subcontractor.setAddress(address);
        }
        if (subContractorDTO.getFinancialDetailId() != null) {
            FinancialDetail financialDetail = financialDetailRepo.findById(subContractorDTO.getFinancialDetailId())
                    .get();
            subcontractor.setFinancialDetail(financialDetail);
        }
        subContractorRepo.save(subcontractor);
        return null;
    }

    @Override
    public SubContractorServiceResponse getSubContractors(SubContractorServiceRequest subContractorServiceRequest) {
        List<SubContractor> subContractorList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();
        List<Association> associations = new ArrayList<>();

        SubContractorSearchDTO subContractorSearchDTO = subContractorServiceRequest.getSubContractorSearchDTO();
        if (subContractorSearchDTO != null) {
            List<Long> idList = subContractorSearchDTO.getIdList();
            List<String> nameList = subContractorSearchDTO.getNameList();
            List<String> codeList = subContractorSearchDTO.getCodeList();
            List<Boolean> activeList = subContractorSearchDTO.getActiveList();
            List<Long> addressIdList = subContractorSearchDTO.getAddressIdList();
            List<Long> financialDetailIdList = subContractorSearchDTO.getFinancialDetailIdList();

            FilterUtils.createEqualFilter(filters, SubContractorSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, SubContractorSearchDTO.NAME, nameList);
            FilterUtils.createEqualFilter(filters, SubContractorSearchDTO.CODE, codeList);
            FilterUtils.createEqualFilter(filters, SubContractorSearchDTO.ACTIVE, activeList);
            FilterUtils.createEqualFilter(filters, SubContractorSearchDTO.ADDRESSID, addressIdList);
            FilterUtils.createEqualFilter(filters, SubContractorSearchDTO.FINANCIALDETAILID, financialDetailIdList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }

            AssociationUtils.createAssociation(associations, SubContractorSearchDTO.ADDRESS,
                    subContractorSearchDTO.isAddressNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }

            AssociationUtils.createAssociation(associations, SubContractorSearchDTO.FINANCIALDETAIL,
                    subContractorSearchDTO.isFinancialDetailNeeded());

            if (CollectionUtils.isNotEmpty(associations)) {
                searchObject.setAssociations(associations);
            }
        }
        searchObject.setPageIndex(subContractorServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(subContractorServiceRequest.getRecordstoFetch());
        subContractorList = subContractorRepo.search(searchObject);

        List<SubContractorDTO> subContractorDTOList = new ArrayList<>();
        for (SubContractor target : subContractorList) {
            subContractorDTOList.add(
                    (SubContractorDTO) conversionUtility.convert(target, SubContractor.class, SubContractorDTO.class));
        }
        SubContractorServiceResponse subContractorServiceResponse = new SubContractorServiceResponse();
        subContractorServiceResponse.setSubContractorDTOList(subContractorDTOList);
        return subContractorServiceResponse;
    }

    @Override
    public SubContractorServiceResponse updateSubContractor(SubContractorServiceRequest subContractorServiceRequest) {
        SubContractorDTO source = subContractorServiceRequest.getSubContractorDTO();

        SubContractor target = subContractorRepo.findById(source.getId()).get();
        target.setName(source.getName());
        target.setCode(source.getCode());
        target.setActive(source.getActive());

        if (source.getAddressId() != null && !source.getAddressId().equals(target.getAddressId())) {
            Address address = addressRepo.findById(source.getAddressId()).get();
            target.setAddress(address);
        }
        if (source.getFinancialDetailId() != null
                && !source.getFinancialDetailId().equals(target.getFinancialDetailId())) {
            FinancialDetail financialDetail = financialDetailRepo.findById(source.getFinancialDetailId()).get();
            target.setFinancialDetail(financialDetail);
        }

        subContractorRepo.save(target);
        return null;
    }

    @Override
    public SubContractorServiceResponse deleteSubContractor(SubContractorServiceRequest subContractorServiceRequest) {
        SubContractorDTO subContractorDTO = subContractorServiceRequest.getSubContractorDTO();
        subContractorRepo.deleteById(subContractorDTO.getId());
        return null;
    }

    @Override
    public AddressServiceRequest createAddressServiceRequest(SubContractorServiceRequest subContractorServiceRequest) {
        AddressServiceRequest addressServiceRequest = new AddressServiceRequest();
        AddressDTO addressDTO = new AddressDTO();
        addressServiceRequest.setAddressDTO(addressDTO);
        return addressServiceRequest;
    }

    @Override
    public FinancialDetailServiceRequest createFinancialDetailServiceRequest(
            SubContractorServiceRequest subContractorServiceRequest) {
        FinancialDetailServiceRequest financialDetailServiceRequest = new FinancialDetailServiceRequest();
        FinancialDetailDTO financialDetailDTO = new FinancialDetailDTO();
        financialDetailServiceRequest.setFinancialDetailDTO(financialDetailDTO);
        return financialDetailServiceRequest;
    }

    @Override
    public void updateSubContractorServiceRequest(SubContractorServiceRequest subContractorServiceRequest,
            AddressServiceResponse addressServiceResponse,
            FinancialDetailServiceResponse financialDetailServiceResponse) {
        SubContractorDTO subContractorDTO = subContractorServiceRequest.getSubContractorDTO();
        subContractorDTO.setFinancialDetailId(financialDetailServiceResponse.getFinancialDetailDTO().getId());
        subContractorDTO.setAddressId(addressServiceResponse.getAddressDTO().getId());
    }
}