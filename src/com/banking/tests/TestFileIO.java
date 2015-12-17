package com.banking.tests;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.banking.businessobject.Account;
import com.banking.businessobject.User;
import com.banking.implementation.FileIO;
import com.banking.interfaces.IFileIO;

public class TestFileIO {
	Account account;
	User user;
	IFileIO fio;

	@Before
	public void setUp() throws Exception {
		account = new Account(7, 2708, 2708);
		user = new User("anurag", "anurag@eanurag.com", new BigInteger(String.valueOf("8105720566")), account);
		fio = new FileIO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntitalizeTransactionFile() {
		assertEquals(true, fio.intitalizeTransactionFile());
	}

	@Test
	public void testReadTransactionFile() {
		assertEquals(user, fio.readTransactionFile(user));
	}

	@Test
	public void testWriteTransactionFile() {
		account = new Account(8, 3688, 9876);
		user = new User("kunal", "kunal@ikunal.in", new BigInteger(String.valueOf("9931027123")), account);
		assertEquals(true, fio.writeTransactionFile(user));
	}

}
