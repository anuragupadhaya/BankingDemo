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
	SmsGatewayImpl sms;
	String trnMessage;

	@Before
	public void setUp() throws Exception {
		account = new Account(8, 3688, 9876);
		user = new User("kunal", "kunal@ikunal.in", new BigInteger(String.valueOf("9931027123")), account);
		trnMessage = "tx|101|102|1100|3688|9876|kunal@ikunal.in";
		String[] messageArray = trnMessage.trim().split("\\|");
		trnObj = new Transaction(messageArray);
		sms = new SmsGatewayImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReceiveNextMessage() {
		sms.receiveNextMessage(trnMessage, user);
		assertEquals("9931027123:PIN authenticated", sms.getAuthPinNotification());
		assertEquals("9931027123:TPIN authenticated", sms.getTransPinNotification());

		// check for profile modification
		trnMessage = "mo|101|000|000|3688|9876|kunal@ikunal.in";
		String[] messageArray = trnMessage.trim().split("\\|");
		trnObj = new Transaction(messageArray);

		sms.receiveNextMessage(trnMessage, user);

	}

	@Test
	public void testNotifyPinAuthenticationResult() {
		String result = sms.notifyPinAuthenticationResult(user, true);
		assertEquals("9931027123:PIN authenticated", result);
	}

	@Test
	public void testNotifyTransPinAuthenticationResult() {
		String result = sms.notifyTransPinAuthenticationResult(user, true);
		assertEquals("9931027123:TPIN authenticated", result);
	}

	@Test
	public void testNotifyTransactionResult() {
		String result = sms.notifyTransactionResult(user, trnObj, true);
		assertEquals("9931027123:Txn completed for " + trnObj.toString(), result);
	}

	@Test
	public void testNotifyProfileUpdateResult() {
		String result = sms.notifyProfileUpdateResult(user, trnObj, true);
		assertEquals("9931027123:Update completed for " + trnObj.toString(), result);
	}

}
