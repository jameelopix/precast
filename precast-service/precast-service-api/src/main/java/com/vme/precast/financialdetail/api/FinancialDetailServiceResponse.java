package com.vme.precast.financialdetail.api;

import java.util.List;

import coliseum.service.BaseServiceResponse;

public class FinancialDetailServiceResponse extends BaseServiceResponse {

 private static final long serialVersionUID = 1L;

 private List<FinancialDetailDTO> financialDetailDTOList;

 public List<FinancialDetailDTO> getFinancialDetailDTOList() {
 return financialDetailDTOList;
 }

 public void setFinancialDetailDTOList(List<FinancialDetailDTO> financialDetailDTOList) {
 this.financialDetailDTOList = financialDetailDTOList;
 }
}