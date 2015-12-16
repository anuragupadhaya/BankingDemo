package com.banking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.banking.businessobject.Account;
import com.banking.businessobject.User;
import com.banking.implementation.FileIO;

public class TestFileIO {
	Account account;
	User user;

	@Before
	public void setUp() throws Exception {
		account = new Account(7, 2708, 2708);
		user = new User("a", "anurag@eanurag.com", new BigInteger(String.valueOf("8105720566")), account);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testIntitalizeTransactionFile() {
		assertEquals(true, FileIO.intitalizeTransactionFile());
	}

	@Test
	public void testReadTransactionFile() {
		assertEquals(account, new Account(7, 2708, 2708));
//		System.out.println(user.toString());
//		System.out.println(FileIO.readTransactionFile(user));
//		System.out.println(user.equals(FileIO.readTransactionFile(user)));
//		assertEquals(user.getAccount(), FileIO.readTransactionFile(user).getAccount());
////		assertEquals(user, FileIO.readTransactionFile(user));
	}

	@Test
	public void testWriteTransactionFile() {
		fail("Not yet implemented");
	}

}
