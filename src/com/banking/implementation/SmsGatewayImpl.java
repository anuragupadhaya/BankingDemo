package com.banking.implementation;

import com.banking.businessobject.Transaction;
import com.banking.interfaces.ISmsGateway;
import com.banking.interfaces.ITransaction;

public class SmsGatewayImpl implements ISmsGateway {

	@Override
	public void sendMessage(Integer mobileNumber, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] receiveNextMessage(String message) {
		// makes more sense to initialize and set a User BO here and pass it
		// along?
		String[] messageArray = message.trim().split("|");
		Transaction trnObj = new Transaction(messageArray);
		ITransaction trn = new TransactionImpl();
		switch (trnObj.getTransactionType().toLowerCase()) {
		case "tx":
			if(trn.accountAuthentication(user, trnObj))
			// call to Transaction type processing function in iTransaction
			break;

		case "mo":
			// call to Profile Modification type processing function in
			// iTransaction
			break;

		default:
			// add error handling code here
			System.out.println("Incorrect Transaction Query format");
			break;
		}
		return messageArray;
	}
}
