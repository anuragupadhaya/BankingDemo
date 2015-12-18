package com.banking.businessobject;

public class Transaction {
	// format of transaction message will be as below
	// tx|101|102|20000|pass11|pass22|anurag@eanurag.com
	// mo| | | |pass11|pass22|newemail@gmail.com
	private String transactionType;
	private Integer fromAccountNumber;
	private Integer toAccountNumber;
	private Integer transactionAmount;
	private Integer authPin;
	private Integer transactionPin;
	private String email;

	public Transaction(String[] messageArray) {
		this.transactionType = messageArray[0].toLowerCase();
		this.fromAccountNumber = Integer.valueOf(messageArray[1]);
		this.toAccountNumber = Integer.valueOf(messageArray[2]);
		this.transactionAmount = Integer.valueOf(messageArray[3]);
		this.authPin = Integer.valueOf(messageArray[4]);
		this.transactionPin = Integer.valueOf(messageArray[5]);
		this.email = messageArray[6].toLowerCase();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	@Override
	public String toString() {
		return transactionType + "|" + fromAccountNumber + "|"
				+ toAccountNumber + "|" + transactionAmount + "|" + authPin
				+ "|" + transactionPin;
	}
}
