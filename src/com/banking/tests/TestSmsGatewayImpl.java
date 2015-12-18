package com.banking.tests;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.banking.businessobject.Account;
import com.banking.businessobject.Transaction;
import com.banking.businessobject.User;
import com.banking.implementation.SmsGatewayImpl;
import com.banking.interfaces.ISmsGateway;

public class TestSmsGatewayImpl {

	Account account;
	User user;
	Transaction trnObj;
	ISmsGateway sms;
	String trnMessage;
	String[] messageArray;

	@Before
	public void setUp() throws Exception {
		account = new Account(7, 2708, 2708);
		user = new User("anurag", "anurag@eanurag.com", new BigInteger(
				String.valueOf("8105720566")), account);
		trnMessage = "tx|101|102|20000|2708|2708|anurag@gmail.com";
		messageArray = trnMessage.trim().split("\\|");
		trnObj = new Transaction(messageArray);
		sms = new SmsGatewayImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReceiveNextMessage() {
		sms.receiveNextMessage(trnMessage);
	}

	@Test
	public void testNotifyPinAuthenticationResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyTransPinAuthenticationResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyTransactionResult() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyProfileUpdateResult() {
		fail("Not yet implemented");
	}

}
