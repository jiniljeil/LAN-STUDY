package com.security.ghost.dto;

public class GroupUserDTO {
	private String name ;
	private String email ; 
	private String date ;
	private int auth ; 
	
	
	public GroupUserDTO() {
	
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getAuth() {
		return auth;
	}


	public void setAuth(int auth) {
		this.auth = auth;
	}
}
	