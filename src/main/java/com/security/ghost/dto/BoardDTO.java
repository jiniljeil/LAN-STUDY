package com.security.ghost.dto;

public class BoardDTO {
	private int id ;
	
	private int user_id ;
	private int group_id ;
	private int type ;
	private String title ; 
	private String content ;
	

	
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
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}

	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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