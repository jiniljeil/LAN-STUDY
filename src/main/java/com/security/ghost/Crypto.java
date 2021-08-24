package com.security.ghost;

import java.security.MessageDigest;

public class Crypto {
	public static String encryptSHA256(String pwd, String salt) {
		try{

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			digest.update(salt.getBytes());
			byte[] hash = digest.digest(pwd.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			
			return hexString.toString();
		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
	}
}
