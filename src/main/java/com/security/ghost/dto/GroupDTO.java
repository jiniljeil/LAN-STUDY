package com.security.ghost.dto;

public class GroupDTO {
	private int id;
	
	private String name;
	private String link;
	private String detail;
	private int managerId;
	private String managerName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
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
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String name) {
		this.managerName = new String(name);
	}
}
