package com.basicsstrong.securecoding;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SensitiveDataProtection {
	
	 public static void saveUser(String username, char[] password) {
	    	
	        String salt = generateSalt();
	        char[] hashedPassword = hashPassword(password, salt);
	        
	        storeInDatabase(username, hashedPassword);
	    }

		private static char[] hashPassword(char[] password, String salt) {
			MessageDigest instance;
			try {
				instance = MessageDigest.getInstance("SHA-256");
				
				char[] saltArray = salt.toCharArray();
				char[] saltedPasswordArray = new char[password.length + saltArray.length];

				// Copy elements from password array
				System.arraycopy(password, 0, saltedPasswordArray, 0, password.length);

				// Copy elements from salt array
				System.arraycopy(saltArray, 0, saltedPasswordArray, password.length, saltArray.length);

				byte[] hashedBytes = instance.digest(new String(saltedPasswordArray).getBytes());
				String str = new String(hashedBytes); 
				return str.toCharArray();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return null;
			}

			
		}

		private static String generateSalt() {
			return "somerandomgeneratedsalt";
		}
		
		private static void storeInDatabase(String username, char[] password) {
		// storing user in database
		
	}


}
