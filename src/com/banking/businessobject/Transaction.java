package com.banking.businessobject;

public class Transaction {
	private String transactionType;
	private Integer fromAccountNumber;
	private Integer toAccountNumber;
	private Integer transactionAmount;
	private Integer authPin;
	private Integer transactionPin;

	public Transaction(String[] messageArray) {
		this.transactionType = messageArray[0].toLowerCase();
		this.fromAccountNumber = Integer.valueOf(messageArray[1]);
		this.toAccountNumber = Integer.valueOf(messageArray[2]);
		this.transactionAmount = Integer.valueOf(messageArray[3]);
		this.authPin = Integer.valueOf(messageArray[4]);
		this.transactionPin = Integer.valueOf(messageArray[5]);
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType.toLowerCase();
	}

	public Integer getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(Integer fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public Integer getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(Integer toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public Integer getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Integer transactionAmount) {
		this.transactionAmount = transactionAmount;
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
