package com.banking.interfaces;

public interface InterfaceSmsGateway {

	public void sendMessage(Integer mobileNumber, String message);

	public String receiveNextMessage(Integer mobileNumber);
}
