package com.security.ghost;


public class StringUtil {
	public String randomAlphanumericStringGenerator(int len) {
        String AlphaNumericString = "0123456789abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        StringBuilder sb = new StringBuilder(len);
  
        for (int i = 0; i < len; i++) {  
            int index = (int)(AlphaNumericString.length()* Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
  
        return sb.toString();
		}
}
