package com.security.ghost.dto;

public class BoardDTO {
	int id ; 
	String title ; 
	byte[] image ; 
	String content ;
	
	public int getId() {
		return id; 
	}
	
	public void setId(int id) {
		this.id = id; 
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = new String(title);
	}
	
	// Q. 
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = new String(content);
	} 
	
}