package com.banking.businessobject;

import java.util.Objects;

public class Account {
	private Integer accountNumber;
	private Integer authPin;
	private Integer transactionPin;

	public Account(Integer accountNumber, Integer authPin,
			Integer transactionPin) {
		this.accountNumber = accountNumber;
		this.authPin = authPin;
		this.transactionPin = transactionPin;
	}

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

	@Override
	public String toString() {
		return accountNumber + "," + authPin + "," + transactionPin;
	}

	@Override
	public boolean equals(Object obj) {
		Account account = (Account) obj;
		return (this.accountNumber.intValue() == account.getAccountNumber()
				.intValue()
				&& this.authPin.intValue() == account.getAuthPin().intValue() && this.transactionPin
					.intValue() == account.getTransactionPin().intValue());
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.accountNumber, this.authPin,
				this.transactionPin);
	}
}
