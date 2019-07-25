package com.vme.precast.financialdetail.controller;

import java.util.List;

import com.vme.precast.financialdetail.api.FinancialDetailDTO;
import com.vme.precast.financialdetail.api.FinancialDetailSearchDTO;

import coliseum.web.BaseClientModel;

public class FinancialDetailClientModel extends BaseClientModel {

 private static final long serialVersionUID = 1L;

 private FinancialDetailDTO financialDetailDTO;

 private FinancialDetailSearchDTO financialDetailSearchDTO;

 private List<FinancialDetailDTO> financialDetailDTOList;

 public FinancialDetailDTO getFinancialDetailDTO() {
 return financialDetailDTO;
 }

 public void setFinancialDetailDTO(FinancialDetailDTO financialDetailDTO) {
 this.financialDetailDTO = financialDetailDTO;
 }

 public List<FinancialDetailDTO> getFinancialDetailDTOList() {
 return financialDetailDTOList;
 }

 public void setFinancialDetailDTOList(List<FinancialDetailDTO> financialDetailDTOList) {
 this.financialDetailDTOList = financialDetailDTOList;
 }

 public FinancialDetailSearchDTO getFinancialDetailSearchDTO() {
 return financialDetailSearchDTO;
 }

 public void setFinancialDetailSearchDTO(FinancialDetailSearchDTO financialDetailSearchDTO) {
 this.financialDetailSearchDTO = financialDetailSearchDTO;
 }

}