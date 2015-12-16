package com.banking.implementation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.banking.businessobject.Account;
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
		String currentLine = "";

		try {
			br = new BufferedReader(new FileReader(TRANSACTION_FILE));
			while ((currentLine = br.readLine()) != null) {
				if (currentLine.contains(user.getEmail().toLowerCase())) {
					break;
				}
			}
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] objectValue = currentLine.split(",");
		Account account = new Account(Integer.valueOf(objectValue[3]),Integer.valueOf(objectValue[4]),Integer.valueOf(objectValue[5]));
		User newUser = new User(objectValue[0], objectValue[1], Integer.valueOf(objectValue[2]), account);
		return newUser;
	}
}
