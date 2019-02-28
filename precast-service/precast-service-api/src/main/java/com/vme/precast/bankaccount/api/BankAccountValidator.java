package com.vme.precast.bankaccount.api;

import coliseum.service.ColiseumInterface;
import coliseum.service.ErrorDTO;

public interface BankAccountValidator extends ColiseumInterface {

	public ErrorDTO checkBankAccountDuplicate(BankAccountServiceRequest bankAccountServiceRequest);
}
