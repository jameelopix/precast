package com.vme.precast.project.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface ProjectValidator extends ColiseumInterface {

	public ErrorDTO checkProjectDuplicate(ProjectServiceRequest projectServiceRequest);
}
