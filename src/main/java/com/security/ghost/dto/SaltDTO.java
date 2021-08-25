package com.security.ghost.dto;

public class SaltDTO {
	private int id ;
	private int user_id ; 
	private byte[] salt ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt; 
	}
	
	public byte[] getSalt() {
		return this.salt; 
	}
}
