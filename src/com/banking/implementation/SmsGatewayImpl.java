package com.banking.implementation;

import java.math.BigInteger;

import com.banking.businessobject.Account;
import com.banking.businessobject.Transaction;
import com.banking.businessobject.User;
import com.banking.interfaces.ISmsGateway;
import com.banking.interfaces.ITransaction;

public class SmsGatewayImpl implements ISmsGateway {

	private String authPinNotification = "";
	private String transPinNotification = "";
	private String transactionNotification = "";
	private String profileUpdateNotification = "";

	@Override
	public void receiveNextMessage(String message) {
		// format of transaction message will be as below
		// tx|101|102|20000|pass11|pass22|anurag@eanurag.com
		// mo| | | |pass11|pass22|newemail@gmail.com
		String[] messageArray = message.trim().split("\\|");
		Transaction trnObj = new Transaction(messageArray);
		ITransaction trnImpl = new TransactionImpl();

		Account account = new Account(Integer.valueOf(messageArray[0]),
				Integer.valueOf(messageArray[2]),
				Integer.valueOf(messageArray[3]));
		User user = new User("", messageArray[4], new BigInteger(
				messageArray[1]), account);
		boolean authenticated = trnImpl.accountAuthentication(user, trnObj);

		switch (trnObj.getTransactionType().toLowerCase()) {
		case "tx":
			authPinNotification = notifyPinAuthenticationResult(user,
					authenticated);
			if (!authPinNotification.isEmpty() && authPinNotification != null) {
				System.out.println(authPinNotification);
			}
			if (trnObj.getTransactionAmount() > 1000) {
				transPinNotification = notifyTransPinAuthenticationResult(user,
						authenticated);
			}
			if (!transPinNotification.isEmpty() && transPinNotification != null) {
				System.out.println(transactionNotification);
			}
			break;

		case "mo":
			authPinNotification = notifyPinAuthenticationResult(user,
					authenticated);
			if (!authPinNotification.isEmpty() && authPinNotification != null) {
				System.out.println(authPinNotification);
			}

			trnImpl.profileUpdate(user, trnObj);

			profileUpdateNotification = notifyProfileUpdateResult(user, trnObj,
					authenticated);

			if (!profileUpdateNotification.isEmpty()
					&& profileUpdateNotification != null) {
				System.out.println(profileUpdateNotification);
			}
			break;

		default:
			// add error handling code here
			System.out.println("Incorrect Transaction Query format");
			break;
		}
	}

	@Override
	public String notifyPinAuthenticationResult(User user,
			boolean authentication) {
		if (authentication) {
			return (user.getMobileNumber() + ":PIN authenticated");
		}
		return ("Error:" + user.getMobileNumber() + ":PIN authentication failed");
	}

	@Override
	public String notifyTransPinAuthenticationResult(User user,
			boolean authentication) {
		if (authentication) {
			return (user.getMobileNumber() + ":TPIN authenticated");
		}
		return ("Error:" + user.getMobileNumber() + ":TPIN authentication failed");
	}

	@Override
	public String notifyTransactionResult(User user, Transaction trnObj,
			boolean transaction) {
		if (transaction) {
			return (user.getMobileNumber() + ":Txn completed for " + trnObj
					.toString());
		}
		return ("Error:" + user.getMobileNumber() + ":Txn failed for " + trnObj
				.toString());
	}

	@Override
	public String notifyProfileUpdateResult(User user, Transaction trnObj,
			boolean authenticated) {
		if (authenticated) {
			return (user.getMobileNumber() + ":Update completed for " + trnObj
					.toString());
		}
		return ("Error:" + user.getMobileNumber() + ":Update failed for " + trnObj
				.toString());
	}

}
