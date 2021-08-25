package com.security.ghost.dto;

public class AdDTO {
	int id ; 
	
	int group_id ; 
	int user_id ; 
	String title; 
	String content;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = new String(title);
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = new String(content);
	} 
	
	
}
