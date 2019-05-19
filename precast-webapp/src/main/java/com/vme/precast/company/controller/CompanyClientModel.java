package com.vme.precast.company.controller;

import java.util.List;

import com.vme.precast.company.api.CompanyDTO;
import com.vme.precast.company.api.CompanySearchDTO;

import coliseum.web.BaseClientModel;

public class CompanyClientModel extends BaseClientModel {

    private static final long serialVersionUID = 1L;

    private CompanyDTO companyDTO;

    private CompanySearchDTO companySearchDTO;

    private List<CompanyDTO> companyDTOList;

    public CompanyDTO getCompanyDTO() {
        return companyDTO;
    }

    public void setCompanyDTO(CompanyDTO companyDTO) {
        this.companyDTO = companyDTO;
    }

    public List<CompanyDTO> getCompanyDTOList() {
        return companyDTOList;
    }

    public void setCompanyDTOList(List<CompanyDTO> companyDTOList) {
        this.companyDTOList = companyDTOList;
    }

    public CompanySearchDTO getCompanySearchDTO() {
        return companySearchDTO;
    }

    public void setCompanySearchDTO(CompanySearchDTO companySearchDTO) {
        this.companySearchDTO = companySearchDTO;
    }

}