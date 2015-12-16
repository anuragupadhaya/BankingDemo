package com.banking.implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

import com.banking.businessobject.Account;
import com.banking.businessobject.User;

public class FileIO {
	// private final static String TRANSACTION_FILE =
	// "c:\\bank_transaction.txt";
	private final static String TRANSACTION_FILE = "/Users/anurag/bank_transaction.txt";

	public static boolean intitalizeTransactionFile() {
		// Initialize the file
		try {
			File file = new File(TRANSACTION_FILE);

			if (file.createNewFile()) {
				System.out.println("Transaction File created");
			} else {
				System.out.println("Transaction File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
			// check if this actually returns false
			return false;
		}
		return true;
	}

	public static User readTransactionFile(User user) {

		BufferedReader br = null;
		String currentLine = "";

		try {
			br = new BufferedReader(new FileReader(TRANSACTION_FILE));
			while ((currentLine = br.readLine()) != null) {
				if (currentLine.contains(user.getEmail().toLowerCase())) {
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String[] objectValue = currentLine.trim().split(",");
		Account account = new Account(Integer.valueOf(objectValue[3]), Integer.valueOf(objectValue[4]),
				Integer.valueOf(objectValue[5]));
		User newUser = new User(objectValue[0], objectValue[1], new BigInteger(objectValue[2]), account);
		return newUser;

		// to add exception code here if the record is not found
	}

	public static boolean writeTransactionFile(User user) {

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter(TRANSACTION_FILE, true));
			bw.write("\n" + user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// check if flush is important
			bw.flush();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// again check for error handling here
		return true;
	}
}
