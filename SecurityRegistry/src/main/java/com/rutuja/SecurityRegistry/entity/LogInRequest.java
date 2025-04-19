package com.rutuja.SecurityRegistry.entity;

public class LogInRequest {
	
	private String name;
	private String passcode;
	public LogInRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogInRequest(String name, String passcode) {
		super();
		this.name = name;
		this.passcode = passcode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasscode() {
		return passcode;
	}
	public void setPasscode(String passcode) {
		this.passcode = passcode;
	}
	@Override
	public String toString() {
		return "LogInRequest [name=" + name + ", passcode=" + passcode + "]";
	}
	
	

}
