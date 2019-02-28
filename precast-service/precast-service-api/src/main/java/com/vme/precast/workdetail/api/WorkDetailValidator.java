package com.vme.precast.workdetail.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface WorkDetailValidator extends ColiseumInterface {

	public ErrorDTO checkWorkDetailDuplicate(WorkDetailServiceRequest workDetailServiceRequest);
}
