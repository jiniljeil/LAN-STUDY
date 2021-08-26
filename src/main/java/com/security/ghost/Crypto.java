package com.security.ghost;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Crypto {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static byte[] generateSalt() {
		byte[] salt = new byte[16]; 
		new SecureRandom().nextBytes(salt);
		return salt ;
	}
	
	public static String encryptSHA256(String pwd, byte[] salt) {
		StringBuilder sb = null; 
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.reset();
			md.update(salt);
			byte[] hashBytes = md.digest(pwd.getBytes("UTF-8"));
			sb = new StringBuilder();

			for(byte b : hashBytes) {
				sb.append(String.format("%02x", b)); 
			}
		} catch(RuntimeException ex){
			System.err.println("런타임 에러 발생");
		} catch(NoSuchAlgorithmException ex) {
			System.err.println("올바르지 않은 알고리즘 사용"); 
		} catch(UnsupportedEncodingException ex) {
			System.err.println("지원하지 않는 인코딩 방식 사용");
		}
		return sb.toString();
	}
}