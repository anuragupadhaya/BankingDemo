package com.banking.businessobject;

import java.math.BigInteger;
import java.util.Objects;

public class User {
	private String userName;
	private String email;
	private BigInteger mobileNumber;
	private Account account;

	public User(String userName, String email, BigInteger mobileNumber,
			Account account) {
		this.userName = userName.toLowerCase();
		this.email = email.toLowerCase();
		this.mobileNumber = mobileNumber;
		this.account = account;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName.toLowerCase();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return userName + "|" + email + "|" + mobileNumber + "|" + account;
	}

	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return (this.userName.equals(user.getUserName())
				&& this.email.equals(user.getEmail())
				&& this.mobileNumber.intValue() == user.getMobileNumber()
						.intValue() && this.account.equals(user.getAccount()));

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(this.userName, this.email, this.mobileNumber,
				this.account);
	}
}
