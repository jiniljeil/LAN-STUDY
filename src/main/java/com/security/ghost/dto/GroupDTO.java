package com.security.ghost.dto;

public class GroupDTO {
	private String name;
	private String link;
	private String detail;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = new String(name);
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = new String(link);
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = new String(detail);
	}
}
