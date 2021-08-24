package com.security.ghost;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class Crypto {
	
	public static byte[] generateSalt() {
		byte[] salt = new byte[16]; 
		new SecureRandom().nextBytes(salt);
		return salt ;
	}
	
	public static String encryptSHA256(String pwd, byte[] salt) {
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.reset();
			md.update(salt);
			byte[] hashBytes = md.digest(pwd.getBytes("UTF-8"));
			StringBuilder sb = new StringBuilder();

			for(byte b : hashBytes) {
				sb.append(String.format("%02x", b)); 
			}
			
			return sb.toString();
			
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
