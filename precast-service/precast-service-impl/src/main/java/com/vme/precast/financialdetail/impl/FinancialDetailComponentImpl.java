package com.vme.precast.financialdetail.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vme.precast.domain.FinancialDetail;
import com.vme.precast.financialdetail.api.FinancialDetailComponent;
import com.vme.precast.financialdetail.api.FinancialDetailDTO;
import com.vme.precast.financialdetail.api.FinancialDetailSearchDTO;
import com.vme.precast.financialdetail.api.FinancialDetailServiceRequest;
import com.vme.precast.financialdetail.api.FinancialDetailServiceResponse;
import com.vme.precast.repository.FinancialDetailRepo;

import coliseum.jpa.Filter;
import coliseum.jpa.SearchObject;
import coliseum.service.ConversionUtility;
import coliseum.service.FilterUtils;

public class FinancialDetailComponentImpl implements FinancialDetailComponent {
    @Autowired
    FinancialDetailRepo financialDetailRepo;

    @Autowired
    ConversionUtility conversionUtility;

    @Override
    public FinancialDetailServiceResponse createFinancialDetail(
            FinancialDetailServiceRequest financialDetailServiceRequest) {
        FinancialDetailDTO financialDetailDTO = financialDetailServiceRequest.getFinancialDetailDTO();
        FinancialDetail financialdetail = (FinancialDetail) conversionUtility.convert(financialDetailDTO,
                FinancialDetailDTO.class, FinancialDetail.class);
        financialDetailRepo.save(financialdetail);
        return null;
    }

    @Override
    public FinancialDetailServiceResponse getFinancialDetails(
            FinancialDetailServiceRequest financialDetailServiceRequest) {
        List<FinancialDetail> financialDetailList = new ArrayList<>();
        List<Filter> filters = new ArrayList<>();
        SearchObject searchObject = new SearchObject();

        FinancialDetailSearchDTO financialDetailSearchDTO = financialDetailServiceRequest.getFinancialDetailSearchDTO();
        if (financialDetailSearchDTO != null) {
            List<Long> idList = financialDetailSearchDTO.getIdList();
            List<String> gstList = financialDetailSearchDTO.getGstList();
            List<String> panList = financialDetailSearchDTO.getPanList();

            FilterUtils.createEqualFilter(filters, FinancialDetailSearchDTO.ID, idList);
            FilterUtils.createEqualFilter(filters, FinancialDetailSearchDTO.GST, gstList);
            FilterUtils.createEqualFilter(filters, FinancialDetailSearchDTO.PAN, panList);

            if (CollectionUtils.isNotEmpty(filters)) {
                searchObject.setFilters(filters);
            }
        }
        searchObject.setPageIndex(financialDetailServiceRequest.getPageIndex());
        searchObject.setRecordstoFetch(financialDetailServiceRequest.getRecordstoFetch());
        financialDetailList = financialDetailRepo.search(searchObject);

        List<FinancialDetailDTO> financialDetailDTOList = new ArrayList<>();
        for (FinancialDetail target : financialDetailList) {
            financialDetailDTOList.add((FinancialDetailDTO) conversionUtility.convert(target, FinancialDetail.class,
                    FinancialDetailDTO.class));
        }
        FinancialDetailServiceResponse financialDetailServiceResponse = new FinancialDetailServiceResponse();
        financialDetailServiceResponse.setFinancialDetailDTOList(financialDetailDTOList);
        return financialDetailServiceResponse;
    }

    @Override
    public FinancialDetailServiceResponse updateFinancialDetail(
            FinancialDetailServiceRequest financialDetailServiceRequest) {
        FinancialDetailDTO source = financialDetailServiceRequest.getFinancialDetailDTO();

        FinancialDetail target = financialDetailRepo.findById(source.getId()).get();
        target.setGst(source.getGst());
        target.setPan(source.getPan());

        financialDetailRepo.save(target);
        return null;
    }

    @Override
    public FinancialDetailServiceResponse deleteFinancialDetail(
            FinancialDetailServiceRequest financialDetailServiceRequest) {
        FinancialDetailDTO financialDetailDTO = financialDetailServiceRequest.getFinancialDetailDTO();
        financialDetailRepo.deleteById(financialDetailDTO.getId());
        return null;
    }
}