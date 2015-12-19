package com.banking.main;

import java.math.BigInteger;
import java.util.Scanner;

import com.banking.businessobject.Account;
import com.banking.businessobject.User;
import com.banking.implementation.FileIO;
import com.banking.implementation.SmsGatewayImpl;
import com.banking.interfaces.IFileIO;
import com.banking.interfaces.ISmsGateway;

public class App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Account account = null;
		User user = null;
		ISmsGateway sms;
		IFileIO fi;

		fi = new FileIO();
		fi.intitalizeTransactionFile();

		System.out.println("Enter the no of records:");
		int records = Integer.valueOf(sc.nextLine());

		for (int i = 1; i <= records; i++) {
			System.out.println("Enter the record no:" + i);
			String message = sc.nextLine();
			String[] objectValue = message.trim().split("\\|");
			account = new Account(Integer.valueOf(objectValue[3]), Integer.valueOf(objectValue[4]),
					Integer.valueOf(objectValue[5]));
			user = new User(objectValue[0], objectValue[1], new BigInteger(objectValue[2]), account);
			fi.writeTransactionFile(user);
		}

		System.out.println("Enter the no of transactions:");
		int numberOfTransactions = Integer.valueOf(sc.nextLine());
		for (int i = 1; i <= numberOfTransactions; i++) {
			System.out.println("Enter the transaction no:" + i);
			String message = sc.nextLine();
			sms = new SmsGatewayImpl();
			sms.receiveNextMessage(message, user);
		}
		sc.close();

	}

}
