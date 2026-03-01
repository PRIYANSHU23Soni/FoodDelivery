package com.tns.fooddeliverysystem.entities;

public class User {
	private int userId;
	private String username;
	private long contactNo;

	public User(int userId,String username, long contactNo) {
		this.userId=userId;
		this.username=username;
		this.contactNo=contactNo;
		
	}
	public int  getuserId() {
		return this.userId;
		
	}
	public String getusername() {
		return this.username;
		
	}
	public long getcontactNo() {
		return this.contactNo;
	}
	@Override
	public String toString() {
		return "user{id="+userId+",name='"+username+"'}";
	}

}
