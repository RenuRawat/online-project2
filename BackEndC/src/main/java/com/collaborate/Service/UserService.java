package com.collaborate.Service;

import com.collaborate.Model.User;

public interface UserService {
	
	boolean registerUser(User user);
	
	boolean isUsernameValid(String username);	
	boolean isEmailValid(String email);
	


}
