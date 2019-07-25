package com.vme.precast.financialdetail.api;

import coliseum.service.BaseServiceRequest;

public class FinancialDetailServiceRequest extends BaseServiceRequest {

 private static final long serialVersionUID = 1L;

 private FinancialDetailDTO financialDetailDTO;

 private FinancialDetailSearchDTO financialDetailSearchDTO;

 public FinancialDetailDTO getFinancialDetailDTO() {
 return financialDetailDTO;
 }

 public void setFinancialDetailDTO(FinancialDetailDTO financialDetailDTO) {
 this.financialDetailDTO = financialDetailDTO;
 }

 public FinancialDetailSearchDTO getFinancialDetailSearchDTO() {
 return financialDetailSearchDTO;
 }

 public void setFinancialDetailSearchDTO(FinancialDetailSearchDTO financialDetailSearchDTO) {
 this.financialDetailSearchDTO = financialDetailSearchDTO;
 }
}
