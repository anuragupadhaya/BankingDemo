package com.banking.implementation;

import com.banking.businessobject.Transaction;
import com.banking.businessobject.User;
import com.banking.interfaces.IFileIO;
import com.banking.interfaces.ITransaction;

public class TransactionImpl implements ITransaction {
	public boolean accountAuthentication(User user, Transaction trnObj) {
		boolean authentication = false;
		IFileIO fi = new FileIO();
		User userRecord = fi.readTransactionFile(user);
		if (userRecord.getMobileNumber().intValue() == user.getMobileNumber().intValue()
				&& userRecord.getAccount().getAuthPin().intValue() == user.getAccount().getAuthPin().intValue()) {
			if (trnObj.getTransactionType().toLowerCase().equals("tx")
					&& trnObj.getTransactionAmount().intValue() > 1000) {
				if (userRecord.getAccount().getTransactionPin().intValue() != user.getAccount().getTransactionPin()
						.intValue()) {
					return authentication;
				}
			}

			authentication = true;
		}
		return authentication;
	}
}
