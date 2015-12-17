package com.banking.interfaces;

public interface ISmsGateway {

	public void sendMessage(Integer mobileNumber, String message);

	public String[] receiveNextMessage(String message);
}
