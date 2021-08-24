package com.security.ghost.dto;

public class SaltDTO {
	String user_id ; 
	byte[] salt ;
	
	public void setUser_id(String user_id) {
		this.user_id = new String(user_id); 
	}
	
	public String getUser_id() {
		return user_id ; 
	}
	
	public void setSalt(byte[] salt) {
		this.salt = salt; 
	}
	
	public byte[] getSalt() {
		return this.salt; 
	}
}
