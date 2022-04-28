package com.winnertech.point_click.security;

public class RegisterForm {

	private String username;
	private String password;
	private String repassword;
	private String name;
	
	public RegisterForm() {
		super();
	}

	public RegisterForm(String username, String password, String repassword) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
