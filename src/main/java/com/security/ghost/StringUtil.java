package com.security.ghost;

import java.security.SecureRandom;

public class StringUtil {
	public String randomAlphanumericStringGenerator(int len) {
        String AlphaNumericString = "0123456789abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        StringBuilder sb = new StringBuilder(len);
		SecureRandom secureRandom = new SecureRandom();
	    
	    for (int i = 0; i < len; i++) {  
	        int index = secureRandom.nextInt(AlphaNumericString.length());
	        sb.append(AlphaNumericString.charAt(index));
	    }
	    System.out.println(sb.toString());
			

        return sb.toString();
		}
}
