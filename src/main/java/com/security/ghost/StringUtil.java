package com.security.ghost;
import java.util.Random;

public class StringUtil {
	public static String randomAlphanumericStringGenerator(int len) {
        String AlphaNumericString = "0123456789abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        StringBuilder sb = new StringBuilder(len);
		Random random = new Random(); 
		
	    for (int i = 0; i < len; i++) {  
	        int index = random.nextInt(AlphaNumericString.length());
	        sb.append(AlphaNumericString.charAt(index));
	    }
			
        return sb.toString();
	}
	
	public static boolean isDigits(String str) {
		for(int i = 0 ;i < str.length(); i++) {
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
}