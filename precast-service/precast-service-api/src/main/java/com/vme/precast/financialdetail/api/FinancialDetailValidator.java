package com.vme.precast.financialdetail.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface FinancialDetailValidator extends ColiseumInterface {

 public ErrorDTO checkFinancialDetailDuplicate(FinancialDetailServiceRequest financialDetailServiceRequest);
}
