package com.vme.precast.financialdetail.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class FinancialDetailServiceResponse extends BaseServiceResponse {

    private static final long serialVersionUID = 1L;

    private List<FinancialDetailDTO> financialDetailDTOList;

    private FinancialDetailDTO financialDetailDTO;

    public List<FinancialDetailDTO> getFinancialDetailDTOList() {
        return financialDetailDTOList;
    }

    public void setFinancialDetailDTOList(List<FinancialDetailDTO> financialDetailDTOList) {
        this.financialDetailDTOList = financialDetailDTOList;
    }

    public FinancialDetailDTO getFinancialDetailDTO() {
        return financialDetailDTO;
    }

    public void setFinancialDetailDTO(FinancialDetailDTO financialDetailDTO) {
        this.financialDetailDTO = financialDetailDTO;
    }
}