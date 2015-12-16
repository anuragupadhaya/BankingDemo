package com.banking.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.banking.businessobject.User;

public class FileIO {
	private final static String TRANSACTION_FILE = "c:\\bank_transaction.txt";

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
		User newUser = new User();

		try {
			String currentLine;
			br = new BufferedReader(new FileReader(TRANSACTION_FILE));
			String email = user.getEmail().toLowerCase();
			while ((currentLine = br.readLine()) != null) {
				if (currentLine.contains(email)) {
					break;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return newUser;
	}
}
