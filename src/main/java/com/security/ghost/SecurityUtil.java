package com.security.ghost;

public class SecurityUtil {
	
	public static String HTML_Filter(String s) {
		String str = s.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;")
		.replaceAll("\\\\", "&quot;").replaceAll("\\'", "&#x27;").replaceAll("\\/", "&#x2F;")
		.replaceAll("\\(", "&#x28;").replaceAll("\\)", "&#x29;");
		return str; 
	}
}
