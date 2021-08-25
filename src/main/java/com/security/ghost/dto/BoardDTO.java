package com.security.ghost.dto;

public class BoardDTO {
	int board_id ; 
	String user_id ;
	String title ; 
	byte[] image ; 
	String content ;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = new String(user_id);
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