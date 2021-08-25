package com.security.ghost.dto;

public class UserDTO {
	private int id ;
	private String name ;
	private String user_id ; 
	private String user_pw ;
	private String phone ; 
	private String email ; 
	
	
	public UserDTO() {
	}
	
	public UserDTO(String user_id, String user_pw) {
		this.user_id = new String(user_id) ;
		this.user_pw = new String(user_pw) ; 
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = new String(name);
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
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = new String(phone);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = new String(email);
	}
	
	
}
