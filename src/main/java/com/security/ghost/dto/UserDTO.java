package com.security.ghost.dto;

import java.sql.Timestamp;

public class UserDTO {
	private int id ;
	private String name ;
	private String user_id ; 
	private String user_pw ;
	private String phone ; 
	private String email ; 
	
	private int trial ;
	private Timestamp login_fail ; 
	private Timestamp login_success; 
	
	public UserDTO() {
		this.trial = 0 ; 
	}
	
	public UserDTO(int trial, String user_id) {
		this.trial = trial ; 
		this.user_id = new String(user_id) ;
	}
	
	public UserDTO(String user_id, String user_pw) {
		this.user_id = new String(user_id) ;
		this.user_pw = new String(user_pw) ; 
	}
	
	public UserDTO(Timestamp second, String user_id, int type) {
		if (type == 1) {
			this.login_success = second ; 
		}else if (type == 0) {
			this.login_fail = second ;
		}
		this.user_id = new String(user_id);
	}
	
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

	public int getTrial() {
		return trial;
	}

	public void setTrial(int trial) {
		this.trial = trial;
	}

	public Timestamp getLogin_fail() {
		return login_fail;
	}

	public void setLogin_fail(Timestamp login_fail) {
		this.login_fail = login_fail;
	}

	public Timestamp getLogin_success() {
		return login_success;
	}

	public void setLogin_success(Timestamp login_success) {
		this.login_success = login_success;
	}
	
	
}
