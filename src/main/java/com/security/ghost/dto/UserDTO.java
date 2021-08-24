package com.security.ghost.dto;

public class UserDTO {
	private int id ; 
	private String user_id ; 
	private String user_pw ;
	private String phone_number ; 
	private String email ; 
	
	private int authority ; 
	private int page_id; 
	
	public UserDTO() {
		authority = 2; 
	}

	public UserDTO(String user_id, String user_pw) {
		this.user_id = user_id ;
		this.user_pw = user_pw ; 
	}
//	@Override
//	public String toString() {
//		return "UserDTO [user_id=" + getUser_id() + ", user_pw=" + getUser_pw() 
//			+ ", phone_number=" + getPhone_number() + ", email=" + getEmail() + "]"; 
//	}
	
	
	public int getId() {
		return id; 
	}
	public void setId(int id) {
		this.id = id ; 
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = new String(user_id);
	}
	
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = new String(user_pw);
	}
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = new String(phone_number);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = new String(email);
	}
	
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	
	public int getPage_id() {
		return page_id;
	}
	public void setPage_id(int page_id) {
		this.page_id = page_id;
	}
	
	
}
