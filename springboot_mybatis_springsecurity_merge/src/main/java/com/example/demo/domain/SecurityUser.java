package com.example.demo.domain;

import java.io.Serializable;

public class SecurityUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String username;
	private String password;
	private int access_level;
	public SecurityUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SecurityUser(int id, String username, String password, int access_level) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.access_level = access_level;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccess_level() {
		return access_level;
	}
	public void setAccess_level(int access_level) {
		this.access_level = access_level;
	}
	@Override
	public String toString() {
		return "SecurityUser [id=" + id + ", username=" + username + ", password=" + password + ", access_level="
				+ access_level + "]";
	}
	
	

}
