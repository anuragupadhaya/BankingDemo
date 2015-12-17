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
import com.banking.interfaces.IFileIO;

public class FileIO implements IFileIO{
	// Test path for Windows machine
	private final static String TRANSACTION_FILE = "c:\\bank_transaction.txt";

	// Test path for MacBook
	// private final static String TRANSACTION_FILE =
	// "/Users/anurag/bank_transaction.txt";

	/* (non-Javadoc)
	 * @see com.banking.implementation.IFileIO#intitalizeTransactionFile()
	 */
	@Override
	public boolean intitalizeTransactionFile() {
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

	/* (non-Javadoc)
	 * @see com.banking.implementation.IFileIO#readTransactionFile(com.banking.businessobject.User)
	 */
	@Override
	public User readTransactionFile(User user) {

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
		Account account = new Account(Integer.valueOf(objectValue[3]),
				Integer.valueOf(objectValue[4]),
				Integer.valueOf(objectValue[5]));
		User newUser = new User(objectValue[0], objectValue[1], new BigInteger(
				objectValue[2]), account);
		System.out.println("User found in the transaction file: "
				+ newUser.toString());
		return newUser;

		// to add exception code here if the record is not found
	}

	/* (non-Javadoc)
	 * @see com.banking.implementation.IFileIO#writeTransactionFile(com.banking.businessobject.User)
	 */
	@Override
	public boolean writeTransactionFile(User user) {
		// **important**
		// Eclipse needs to be *Run as Admin* to have the write access to write
		// to the file
		// Problem with Windows 7+ as of now. Still need to check on Mac.
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
		System.out.println("Record written to the transaction file: "
				+ user.toString());
		return true;
	}
}
