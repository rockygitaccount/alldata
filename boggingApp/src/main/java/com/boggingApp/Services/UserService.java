package com.boggingApp.Services;

import java.util.List;

import com.boggingApp.Payloads.UserDto;

public interface UserService {
	
	public UserDto createUser(UserDto user);
	public UserDto updateUser(UserDto user, Integer userId);
	public UserDto getUserById(Integer userId);
	public List<UserDto> getAllUser();
	public void  deleteUserById(Integer userId);

}
