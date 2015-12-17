package com.banking.implementation;

import com.banking.interfaces.ISmsGateway;

public class SmsGatewayImpl implements ISmsGateway {

	@Override
	public void sendMessage(Integer mobileNumber, String message) {
		// TODO Auto-generated method stub

	}

	@Override
	public String receiveNextMessage(String message) {
		String[] messageArray = message.split("|");
		switch (messageArray[0]) {
		case "Tx":
					
			break;

		case "Mo":

			break;

		default:
			// add error handling code here
			System.out.println("Incorrect Transaction Query format");
			break;
		}
		return null;
	}
}
