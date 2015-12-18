package com.banking.interfaces;

import com.banking.businessobject.Transaction;
import com.banking.businessobject.User;

public interface ISmsGateway {
	public void receiveNextMessage(String message);

	public String notifyPinAuthenticationResult(User user, boolean authentication);

	public String notifyTransPinAuthenticationResult(User user,
			boolean authentication);

	public String notifyTransactionResult(User user, Transaction trnObj,
			boolean transaction);

	public String notifyProfileUpdateResult(User user, Transaction trnObj,
			boolean authenticated);
}
