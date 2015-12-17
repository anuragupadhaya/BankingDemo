package com.banking.interfaces;

import com.banking.businessobject.Transaction;
import com.banking.businessobject.User;

public interface ITransaction {
	public abstract boolean accountAuthentication(User user, Transaction trnObj);
}
