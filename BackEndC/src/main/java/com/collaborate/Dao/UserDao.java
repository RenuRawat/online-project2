package com.collaborate.Dao;



import com.collaborate.Model.User;





public interface UserDao {
	
	
 
boolean isUsernameValid(String username);	
boolean isEmailValid(String email);

 boolean registerUser(User user);
 User login(User user);
 
 // online status
 void update(User user);
 
 User getUserByUsername(String username);
 
 boolean isUpdatedEmailValid(String email, String username);
 

 
 public User getUsernameByUsername(String username);	


}
