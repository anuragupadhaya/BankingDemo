package com.banking.businessobject;

public class User {
	private String userName;
	private String email;
	private Integer mobileNumber;
	private Account account;

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

	public Integer getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Integer mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
