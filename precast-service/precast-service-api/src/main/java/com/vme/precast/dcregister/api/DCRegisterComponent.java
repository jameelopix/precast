package com.vme.precast.dcregister.api;

import coliseum.service.ColiseumInterface;

public interface DCRegisterComponent extends ColiseumInterface {

 public DCRegisterServiceResponse createDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest);

 public DCRegisterServiceResponse getDCRegisters(DCRegisterServiceRequest dCRegisterServiceRequest);

 public DCRegisterServiceResponse updateDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest);

 public DCRegisterServiceResponse deleteDCRegister(DCRegisterServiceRequest dCRegisterServiceRequest);
}
