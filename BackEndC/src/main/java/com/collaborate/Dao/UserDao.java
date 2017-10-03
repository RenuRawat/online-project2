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
 

 
	
/*	public User getUser(int userId);
	
	public List<User> getUsers();
	
	
	// after every login and logout update the user online status
	public	void updateUserOnline(User user);
	
	public boolean approveUser(User user);
	
	public boolean updateUser(int userId);
	
	public boolean deleteUser(int userId);*/

}
