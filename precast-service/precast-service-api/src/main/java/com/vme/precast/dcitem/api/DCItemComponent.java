package com.vme.precast.dcitem.api;

import coliseum.service.ColiseumInterface;

public interface DCItemComponent extends ColiseumInterface {

 public DCItemServiceResponse createDCItem(DCItemServiceRequest dCItemServiceRequest);

 public DCItemServiceResponse getDCItems(DCItemServiceRequest dCItemServiceRequest);

 public DCItemServiceResponse updateDCItem(DCItemServiceRequest dCItemServiceRequest);

 public DCItemServiceResponse deleteDCItem(DCItemServiceRequest dCItemServiceRequest);
}
