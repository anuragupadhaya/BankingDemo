package com.banking.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.banking.businessobject.Account;
import com.banking.businessobject.Transaction;
import com.banking.businessobject.User;
import com.banking.implementation.TransactionImpl;
import com.banking.interfaces.ITransaction;

public class TestTransactionImpl {
	Account account;
	User user;
	Transaction trnObj;
	ITransaction trn;

	@Before
	public void setUp() throws Exception {
		account = new Account(7, 2708, 2708);
		user = new User("anurag", "anurag@eanurag.com", new BigInteger(
				String.valueOf("8105720566")), account);
		String trnMessage = "tx|101|102|20000|2708|2708|anurag@gmail.com";
		String[] messageArray = trnMessage.trim().split("\\|");
		trnObj = new Transaction(messageArray);
		trn = new TransactionImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAccountAuthentication() {
		assertEquals(true, trn.accountAuthentication(user, trnObj));
	}

	@Test
	public void testProfileUpdate() {
		assertEquals(true, trn.profileUpdate(user, trnObj));
	}

}
