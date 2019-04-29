package com.vme.precast.company.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class CompanyServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<CompanyDTO> companyDTOList;

 public List<CompanyDTO> getCompanyDTOList() {
 return companyDTOList;
 }

 public void setCompanyDTOList(List<CompanyDTO> companyDTOList) {
 this.companyDTOList = companyDTOList;
 }
}