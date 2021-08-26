package com.security.ghost;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SecurityUtil {
	
	public static String HTML_Filter(String s) {
		String str = s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
		.replaceAll("\\\\", "&quot;").replaceAll("\\'", "&#x27;").replaceAll("\\/", "&#x2F;")
		.replaceAll("\\(", "&#x28;").replaceAll("\\)", "&#x29;");
		return str; 
	}
	
	// 최소 11자리에 숫자, 문자, 특수문자 각각 1개 이상 포함
	public static boolean isValidPassword(String pass) {
		
		Pattern pattern = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{11,}$");
		
		Matcher matcher = pattern.matcher(pass);
		if (!matcher.matches()) {
			return false;
		} else {
			return true;
		}
	}
}
