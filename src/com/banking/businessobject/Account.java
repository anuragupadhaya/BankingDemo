package com.banking.businessobject;

public class Account {
	private Integer accountNumber;
	private Integer authPin;
	private Integer transactionPin;

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getAuthPin() {
		return authPin;
	}

	public void setAuthPin(Integer authPin) {
		this.authPin = authPin;
	}

	public Integer getTransactionPin() {
		return transactionPin;
	}

	public void setTransactionPin(Integer transactionPin) {
		this.transactionPin = transactionPin;
	}
}
