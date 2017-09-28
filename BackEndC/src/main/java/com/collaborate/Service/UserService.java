package com.collaborate.Service;

import com.collaborate.Model.User;

public interface UserService {
	
	
	
	boolean isUsernameValid(String username);	
	boolean isEmailValid(String email);
	
	boolean registerUser(User user);
	
	 User login(User user);


}
