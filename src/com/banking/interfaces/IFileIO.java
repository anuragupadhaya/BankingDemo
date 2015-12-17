package com.banking.interfaces;

import com.banking.businessobject.User;

public interface IFileIO {

	public abstract boolean intitalizeTransactionFile();

	public abstract User readTransactionFile(User user);

	public abstract boolean writeTransactionFile(User user);

}