package com.basicsstrong.securecoding;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Authentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        
        if (authenticate(username, password)) {
            System.out.println("Authentication successful!");
        } else {
            System.out.println("Authentication failed!");
        }
        
        scanner.close();
    }
    
    public static boolean authenticate(String username, String password) {
    	
        String hashedPasswordFromDatabase = getHashedPasswordFromDatabase(username);
        
        String salt = generateSalt();
        String hashedPassword = hashPassword(password, salt);
        System.out.println(hashedPassword);
        if (hashedPassword.equals(hashedPasswordFromDatabase)) {
            return true;
        } else {
            return false;
        }
    }

	private static String hashPassword(String password, String salt) {
		MessageDigest instance;
		try {
			instance = MessageDigest.getInstance("SHA-256");
			String saltedPassword = password + salt;
			byte[] hashedBytes = instance.digest(saltedPassword.getBytes());
			StringBuilder builder = new StringBuilder();
			for (byte b : hashedBytes) {
				builder.append(String.format("%02x", b));
			}
			return builder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}

		
	}

	private static String generateSalt() {
		return "somerandomgeneratedsalt";
	}

	private static String getHashedPasswordFromDatabase(String username) {
		return "1a3b63af81e416crfd887edd20fce8c5e16017cb878ef2858fc70aab70afbc78b";
	}
}

