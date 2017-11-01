package com.collaborate.Service;

import com.collaborate.Model.User;

public interface UserService {
	
	
	
public	boolean isUsernameValid(String username);	
public boolean isEmailValid(String email);
	
public	boolean registerUser(User user);
	
public User login(User user);
	 
	 // online status
public void update(User user);
	 
	 
public User getUserByUsername(String username);

public boolean isUpdatedEmailValid(String email, String username);

public User getUsernameByUsername(String username);


}
