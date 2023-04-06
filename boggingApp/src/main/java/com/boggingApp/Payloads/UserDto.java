package com.boggingApp.Payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class UserDto {
	
	private int id;
	//@NotNull(message = "name should not be empty")
	@NotEmpty(message = "name shouls not be empty")
	//@Size(min=4, message = "username must be minimum of 4 charactor!!")
	private String name;
	
	@Email(message = "Email address is not valid!!")
	private String email;
	@NotEmpty(message = "password can not be empty")
	//At least 8 chars one digit one lower alpha char and one upper alpha char, special chars (@#%$^_ etc.), not contain space, tab, etc.
	@Size(min = 8, max = 30, message = "password must be min 3 charactor and max 10 charactor!!")
	@Pattern(regexp = "^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&_+=]).*$")
	private String password;
	@NotNull
	private String about;
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
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public UserDto() {
		
	}
	
}
